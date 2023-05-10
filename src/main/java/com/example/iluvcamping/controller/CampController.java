package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.camp.CampRequestDTO;
import com.example.iluvcamping.domain.campTheme.CampTheme;
import com.example.iluvcamping.domain.campTheme.CampThemeRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import com.example.iluvcamping.service.CampService;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final CampThemeRepository campThemeRepository;

    @GetMapping("/viewCampsite")
    public String viewCampsite(Model model, @RequestParam(value = "campList", required = false) List<CampView> campList) {
        model.addAttribute("campList", campList);
        return "viewcampsite";
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
}

    @PostMapping("/camp/regist")
    public String campRegist (@RequestBody CampRequestDTO campDto, HttpSession session) {
        Camp camp = new Camp(campDto);
        String code = keyGenerator.randomKey("D");
        camp.setCampCode(code);
        campService.addCamp(camp);

        return "mypage/registsuccess";
    }

}