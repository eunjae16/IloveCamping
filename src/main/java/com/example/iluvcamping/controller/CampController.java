package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import com.example.iluvcamping.service.CampService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<CampView> getCampList(@RequestParam("selectedValue") String selectedValue) {
        List<CampView> campList = campViewRepository.findAllByCampAddress1StartingWith(selectedValue.substring(0, 2));
        return campList;
    }
}