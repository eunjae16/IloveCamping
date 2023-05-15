package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.camp.CampRequestDTO;
import com.example.iluvcamping.domain.campSite.CampSite;
import com.example.iluvcamping.domain.campSite.CampSiteRequestDTO;
import com.example.iluvcamping.domain.campTheme.CampTheme;
import com.example.iluvcamping.domain.campTheme.CampThemeRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import com.example.iluvcamping.domain.categoryCount.CategoryCountRepository;
import com.example.iluvcamping.service.CampService;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class CampController {
    private final CampService campService;
    private final CampThemeNameRepository campThemeNameRepository;
    private final KeyGenerator keyGenerator;
    private final CampRepository campRepository;
    private final CampThemeRepository campThemeRepository;
    private final CategoryCountRepository categoryCountRepository;


    // 지도에 표시할 목적의 모든 camp read
    @GetMapping("/camp/readall")
    @ResponseBody
    public List<CampThemeName> getCampListAll() {
        List<CampThemeName> listTheme = campThemeNameRepository.findAll();

        return listTheme;
    }

    @GetMapping("/camp/campall")
    @ResponseBody
    public List<Camp> getCampForMap() {
        List<Camp> camp = campRepository.findAll();
        return camp;
    }

    @GetMapping("/camptheme/readall")
    public List<CampTheme> getAllCampTheme() {
        List<CampTheme> list = campThemeRepository.findAll();

        return list;
    }

    @PostMapping("/camp/regist")
    public String campRegist (@RequestBody CampRequestDTO campDto, HttpSession session) {
        Camp camp = new Camp(campDto);
        String code = keyGenerator.randomKey("D");
        camp.setCampCode(code);
        campService.addCamp(camp);

        return "mypage/registsuccess";
    }

    @GetMapping("/get/categorycount")
    @ResponseBody
    public String getCategoryCount() {
        String campCount = categoryCountRepository.getCategoryCountByCategoryCode("CT100001");
        int glampingCount = Integer.parseInt(categoryCountRepository.getCategoryCountByCategoryCode("CT100002"));
        int carabanCount = Integer.parseInt(categoryCountRepository.getCategoryCountByCategoryCode("CT100003"));

        String bothCount = String.valueOf(glampingCount + carabanCount);
        int total = Integer.parseInt(campCount) + glampingCount + carabanCount;
        String totalCount = String.valueOf(total);

        return campCount + "," + bothCount + "," + totalCount;
    }

    @GetMapping("/camp/campingcategory")
    @ResponseBody
    public List<Camp> getCampingForMap(){
        String category = "CT100001";
        List<Camp> camping = campRepository.findByCampCategoryCode(category);

        return camping;

    }

    @GetMapping("/camp/glampingcategory")
    @ResponseBody
    public List<Camp> getGlampingForMap(){
        List<String> categoryCodes = new ArrayList<>();
        String glamping = "CT100002";
        String caravan = "CT100003";

        categoryCodes.add(glamping);
        categoryCodes.add(caravan);

        List<Camp> camping = campRepository.findByCampCategoryCodeIn(categoryCodes);

        return camping;

    }


    // 전체페이지 > 검색
    @GetMapping("/camp/search")
    public ModelAndView searchResult (@RequestParam String region, @RequestParam String content) {
        List<CampThemeName> result = null;

        result = campThemeNameRepository.findAllByCampAddress1ContainingAndCampNameContaining(region, content);

        ModelAndView modelAndView = new ModelAndView("camp/searchResult");
        modelAndView.addObject("result", result);

        return modelAndView;
    }


    @PostMapping("/campsite/registcampcode")
    public String campSiteRegistCampCode (@RequestParam("campCode") String campCode, Model model) {
        model.addAttribute("campCode", campCode);
        return "mypage/ownerCampSiteRegist";
    }


    @PostMapping("/campsite/regist")
    @ResponseBody
    public ResponseEntity<CampSite> campSiteRegist(@RequestBody CampSiteRequestDTO campSiteDto) {
        CampSite campSite = new CampSite(campSiteDto);
        String code = keyGenerator.randomKey("K");
        campSite.setSiteCode(code);
        campService.addCampSite(campSite);

        return ResponseEntity.ok(campSite);
    }


    // read [ one ]
    @GetMapping("/camp/readone")
    public Camp getCampByCampCode(@RequestParam String campCode){
        System.out.println("campcode: " +campCode);
        Camp camp = campRepository.getCampByCampCode(campCode);
        return camp;
    }


    @PutMapping("/camp/update")
    @ResponseBody
    public ResponseEntity<Camp> updateByCampCode(@RequestBody CampRequestDTO campDto) {
        try {
            campService.updateCamp(campDto);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
