package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import com.example.iluvcamping.service.CampService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CampController {

    private final CampRepository campRepository;
    private final CampViewRepository campViewRepository;
    private final CampService campService;

    public CampController(CampRepository campRepository, CampViewRepository campViewRepository, CampService campService) {
        this.campRepository = campRepository;
        this.campService = campService;
        this.campViewRepository = campViewRepository;
    }

    @GetMapping("/getCampList")
    @ResponseBody
    public ResponseEntity<List<CampView>> getCampList(@RequestParam("selectedValue") String selectedValue) {
        List<CampView> campList;
        if (selectedValue.equals("viewAll")) {
            campList = campService.getCampAll();
        } else {
            campList = campViewRepository.findAllByCampAddress1StartingWith(selectedValue.substring(0, 2));
        }
        return ResponseEntity.ok(campList);
    }

    @GetMapping("/searchCamp")
    @ResponseBody
    public ResponseEntity<List<CampView>> searchCamp(@RequestParam String selectedOption) {
        List<CampView> campList;
        if (selectedOption.equals("viewAll")) {
            campList = campService.getCampAll();
        } else {
            campList = campViewRepository.findAllByCampAddress1StartingWith(selectedOption.substring(0, 2));
        }
        return ResponseEntity.ok(campList);
    }
}
