package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CampViewController {

    private final CampRepository campRepository;

    @GetMapping("/get/campinfo")
    public ModelAndView getCampInfo(@RequestParam String campCode){

        Camp camp = campRepository.getCampByCampCode(campCode);

        ModelAndView modelAndView = new ModelAndView("/campdetail");
        modelAndView.addObject("camp", camp);

        return modelAndView;
    }

}
