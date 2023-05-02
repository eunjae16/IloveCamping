package com.example.iluvcamping.controller;

import org.springframework.stereotype.Controller;

@Controller
public class CampController {

    private final CampRepository campRepository;

    public CampController(CampRepository campRepository) {
        this.campRepository = campRepository;
    }

    @GetMapping("/getCampList")
    public List<Camp> getCampList(@RequestParam String selectedValue) {
        List<Camp> campList = campRepository.findByCampAddress1StartingWith(selectedValue.substring(0, 2));
        return campList;
    }
}