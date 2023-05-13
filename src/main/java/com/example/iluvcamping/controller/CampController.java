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
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.categoryCount.CategoryCount;
import com.example.iluvcamping.domain.categoryCount.CategoryCountRepository;
import com.example.iluvcamping.domain.reply.ReplyRequestDTO;
import com.example.iluvcamping.service.CampService;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/campsite/search")
    @ResponseBody
    public List<CampView> searchCampsite(@RequestParam("site") String site, @RequestParam("query") String query) {
        if (site.equals("viewAll")) {
            return campService.getAllCamp();
        } else {
            return campService.getCampsByAddressPrefix(site.substring(0, 2));
        }
    }

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
    public List<CategoryCount> getCategoryCount(Model model){
        List<CategoryCount> list = categoryCountRepository.findAll();
        model.addAttribute("list", list);

        return list;
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

    @PostMapping("/campsite/regist")
    public String campSiteRegist (@RequestBody CampSiteRequestDTO campSiteDto, HttpSession session) {
        CampSite campSite = new CampSite(campSiteDto);
        String code = keyGenerator.randomKey("K");
        campSite.setSiteCode(code);
        campService.addCampSite(campSite);

        return "mypage/registsuccess";
    }

    @PutMapping("/campName/update")
    public void updateByCampCode(@RequestParam String campCode, @RequestBody CampRequestDTO campDto) {
        campDto.setCampName(campCode);
        campService.updateCampName(campDto);

    }



}
