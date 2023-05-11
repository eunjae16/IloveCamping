package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityViewRepository;
import com.example.iluvcamping.domain.campSite.CampSite;
import com.example.iluvcamping.domain.campSite.CampSiteRepository;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundViewRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final CampRepository campRepository;
    private final CampFacilityViewRepository campFacilityViewRepository;
    private final CampSurroundViewRepository campSurroundViewRepository;
    private final CampThemeNameRepository campThemeNameRepository;
    private final CampSiteRepository campSiteRepository;

    @GetMapping("/get/campdetail")
    @ResponseBody
    public Camp getCampByCode(@RequestParam String campCode){

        Camp camp = campRepository.getCampByCampCode(campCode);

        return camp;
    }

    @PostMapping("/post/goreservation")
    public String goReservation(@RequestParam("campCode") String campCode, Model model){
        CampThemeName camp = campThemeNameRepository.getCampThemeNameByCampCode(campCode);
        if(camp != null){
            List<CampSite> campsite = campSiteRepository.getAllByCampCode(campCode);
            model.addAttribute("camp", camp);
            model.addAttribute("campsite", campsite);
            return "/booking/bookingCamp";
        }
        else return "error";
    }

//    // create booking


}
