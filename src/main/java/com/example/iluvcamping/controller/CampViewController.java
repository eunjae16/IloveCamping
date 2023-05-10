package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityView;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityViewRepository;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundView;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CampViewController {

    private final CampRepository campRepository;
    private final CampSurroundViewRepository campSurroundViewRepository;
    private final CampFacilityViewRepository campFacilityViewRepository;

    @GetMapping("/get/campinfo")
    @ResponseBody
    public ModelAndView getCampInfo(@RequestParam String campCode){
        Camp camp = campRepository.getCampByCampCode(campCode);
        if(camp != null){

            List<CampSurroundView> surroundList = campSurroundViewRepository.findAllByCampCode(campCode);
            List<CampFacilityView> facilityList = campFacilityViewRepository.findAllByCampCode(campCode);

            ModelAndView modelAndView = new ModelAndView("/camp/campDetailPage");
            modelAndView.addObject("camp", camp);
            modelAndView.addObject("surroundList", surroundList);
            modelAndView.addObject("facilityList", facilityList);
            return modelAndView;
        }
        return null;
    }

    @GetMapping("testtest")
    @ResponseBody
    public List<CampFacilityView> testtest(@RequestParam String campCode){
        List<CampFacilityView> facilityList = campFacilityViewRepository.findAllByCampCode(campCode);

        return facilityList;
    }

}
