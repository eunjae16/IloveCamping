package com.example.iluvcamping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CommunityController controller;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }

    @GetMapping("/clientregister")
    public String clientRegister(){
        return "clientRegister";
    }

    @GetMapping("/ownerregister")
    public String ownerRegister(){
        return "ownerRegister";
    }

    @GetMapping("/joinsuccess")
    public String joinSuccess(){
        return "joinSuccess";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/header")
    public String header(){
        return "header";
    }

    @GetMapping("/footer")
    public String footer(){
        return "footer";
    }

    @GetMapping("/nearsite")
    public String nearSite(){ return "nearSite"; }

    @GetMapping("/weather")
    public String weather(){ return "weather"; }

    @GetMapping("/viewCampsite")
    public String viewCampsite(){
        return "viewCampsite";
    }

    @GetMapping("/community")
    public String community(Model model) {

        List<Community> list = controller.getAllCommunity();
        model.addAttribute("list", list);

        return "community";
    }

    @GetMapping("/communityread")
    public ModelAndView communityRead(@RequestParam String writeCode){
        Community community = controller.getCommunityByWriteCode(writeCode);

        ModelAndView modelAndView = new ModelAndView("communityread");
        modelAndView.addObject("community", community);

        return modelAndView;
    }

    // 게시판 글 작성하는 페이지
    @GetMapping("/communitywrite")
    public String communitywrite() {
        return "communitywrite";
    }


//    @GetMapping("/error")
//    public String error() { return "error"; }

    @GetMapping("/ownerSales")
    public String ownerSales() {
        return "ownerSales";
    }


}
