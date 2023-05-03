package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.service.CampService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CampController {

    private final CampRepository campRepository;
    private final CampService campService;

    public CampController(CampRepository campRepository, CampService campService) {
        this.campRepository = campRepository;
        this.campService = campService;
    }

    @GetMapping("/getCampList")
    public List<Camp> getCampList(@RequestParam("selectedValue") String selectedValue) {
        List<Camp> campList = campRepository.findByCampAddress1StartingWith(selectedValue.substring(0, 2));
        return campList;
    }

    @GetMapping("/getCampAll")
    @ResponseBody
    public List<Camp> getCampAll() {
        return campService.getCampAll();
    }

    @GetMapping("/searchCamp")
    @ResponseBody
    public List<Camp> searchCamp(@RequestParam String selectedOption) {
        List<Camp> campList;

        if (selectedOption.equals("viewAll")) {
            campList = campService.getCampAll();
        } else {
            campList = campRepository.findByCampAddress1StartingWith(selectedOption.substring(0, 2));
        }

        return campList;
    }
}