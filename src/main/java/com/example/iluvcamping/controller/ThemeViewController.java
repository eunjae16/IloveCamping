package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.themeView.ThemeView;
import com.example.iluvcamping.domain.themeView.ThemeViewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
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

    @GetMapping("/selectglamping")
    public String selectGlamping(Model model){
        List<ThemeView> list = themeViewRepository.findByThemeName("글램핑");
        model.addAttribute("glampingThemes", list);
        return "camp/themeGlamping";
    }

    @GetMapping("/selectcaravan")
    public String selectCaravan(Model model){
        List<ThemeView> list = themeViewRepository.findByThemeName("카라반");
        model.addAttribute("caravanThemes", list);
        return "camp/themeCaravan";
    }
}
