package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityViewRepository;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final CampRepository campRepository;
    private final CampFacilityViewRepository campFacilityViewRepository;
    private final CampSurroundViewRepository campSurroundViewRepository;

    @GetMapping("/get/campdetail")
    @ResponseBody
    public Camp getCampByCode(@RequestParam String campCode){

        Camp camp = campRepository.getCampByCampCode(campCode);

        return camp;
    }

}
