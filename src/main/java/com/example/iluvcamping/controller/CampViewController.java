package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityView;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityViewRepository;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundView;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundViewRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.categoryCount.CategoryCountRepository;
import com.example.iluvcamping.service.CampService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CampViewController {
    private final CampService campService;
    private final CampRepository campRepository;
    private final CampSurroundViewRepository campSurroundViewRepository;
    private final CampFacilityViewRepository campFacilityViewRepository;
    private final CampThemeNameRepository campThemeNameRepository;
    private final CampController campController;

    @PostMapping("/get/campinfo")
    @ResponseBody
    public ModelAndView getCampInfo(@RequestParam("campCode") String campCode){
        Camp camp = campRepository.getCampByCampCode(campCode);

        if(camp != null){
            CampThemeName campThemeName = campThemeNameRepository.getCampThemeNameByCampCode(campCode);
            List<CampSurroundView> surroundList = campSurroundViewRepository.findAllByCampCode(campCode);
            List<CampFacilityView> facilityList = campFacilityViewRepository.findAllByCampCode(campCode);

            ModelAndView modelAndView = new ModelAndView("/camp/campDetailPage");
            modelAndView.addObject("camp", camp);
            modelAndView.addObject("surroundList", surroundList);
            modelAndView.addObject("facilityList", facilityList);
            modelAndView.addObject("campThemeName", campThemeName);
            return modelAndView;
        }
        return null;
    }

    @GetMapping("/viewCampsite/search")
    @ResponseBody
    public List<CampView> searchCampsite(@RequestParam("selectedSite") String selectedSite, @RequestParam("query") String query) {
        List<CampView> campList;
        if (selectedSite.equals("viewAll")) {
            campList = campService.getAllCamp();
        } else {
            campList = campService.getCampsByAddressPrefix(selectedSite.substring(0, 2));
        }
        List<CampView> filteredList = new ArrayList<>();
        for (CampView camp : campList) {
            if (camp.getCampAddress1().startsWith(selectedSite.substring(0, 2)) && camp.getCampAddress1().startsWith(query)) {
                filteredList.add(camp);
            }
        }
        return filteredList;
    }


    // 해당 owner가 가진 camp 목록 출력
    @GetMapping("/owner/readcampall")
    public ModelAndView getCampListByOwnerCode(@RequestParam String campOwner) {
        List<Camp> campList = null;
        System.out.println("campow");

        campList = campRepository.getAllByCampOwner(campOwner);

        ModelAndView modelAndView = new ModelAndView("mypage/ownerCampModify");
        modelAndView.addObject("campList", campList);

        return modelAndView;
    }


}
