package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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