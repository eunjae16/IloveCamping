package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.camp.CampRequestDTO;
import com.example.iluvcamping.domain.campTheme.CampTheme;
import com.example.iluvcamping.domain.campTheme.CampThemeRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.categoryCount.CategoryCount;
import com.example.iluvcamping.domain.categoryCount.CategoryCountRepository;
import com.example.iluvcamping.service.CampService;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/viewCampsite")
    public String viewCampsite(@RequestParam(name = "selectSite", required = false) String selectSite,
                               @RequestParam(name = "searchBox", required = false) String searchBox,
                               Model model) {
        List<Camp> campList = new ArrayList<>();

        if (selectSite != null && !selectSite.equals("none")) {
            if (selectSite.equals("viewAll")) {
                campList = campRepository.findAll();
            } else {
                String selectSitePrefix = selectSite.substring(0, 2);
                campList = campRepository.findByCampAddress1StartingWith(selectSitePrefix);
            }
        } else if (searchBox != null && !searchBox.isEmpty()) {
            campList = campService.searchCampByKeyword(searchBox);
        } else {
            campList = campRepository.findAll();
        }

        List<Camp> filteredCampList = new ArrayList<>();
        if (searchBox != null && !searchBox.isEmpty()) {
            for (Camp camp : campList) {
                if (camp.getCampCode().contains(searchBox) ||
                        camp.getCampOwner().contains(searchBox) ||
                        camp.getCampCategoryCode().contains(searchBox) ||
                        camp.getCampName().contains(searchBox) ||
                        camp.getCampImage().contains(searchBox) ||
                        camp.getCampAddressCode().contains(searchBox) ||
                        camp.getCampAddress1().contains(searchBox) ||
                        camp.getCampAddress2().contains(searchBox) ||
                        camp.getCampPhone().contains(searchBox)) {
                    filteredCampList.add(camp);
                }
            }
        } else {
            filteredCampList = campList;
        }

        model.addAttribute("campList", filteredCampList); // 변경: 검색 결과를 사용하도록 수정
        return "viewCampsite";
    }


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
}
