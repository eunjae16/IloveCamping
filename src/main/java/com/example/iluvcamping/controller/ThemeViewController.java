package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.themeView.ThemeView;
import com.example.iluvcamping.domain.themeView.ThemeViewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThemeViewController {
    private final ThemeViewRepository themeViewRepository;

    public ThemeViewController(ThemeViewRepository themeViewRepository){
        this.themeViewRepository = themeViewRepository;
    }

    @GetMapping("/selectcamping")
    public String selectCamping(Model model){
        List<ThemeView> list = themeViewRepository.findByThemeName("캠핑");
        model.addAttribute("campingThemes", list);
        return "camp/themeCamping";
    }

    @GetMapping("/selectglampingandcaravan")
    public String selectThemeExceptCamping(Model model){
        List<ThemeView> exceptCamping = themeViewRepository.findDistinctByThemeNameNotCampfireOrderByThemeName();
        model.addAttribute("exceptCamping", exceptCamping);
        return "camp/themeGlampingAndCaravan";
    }
}
