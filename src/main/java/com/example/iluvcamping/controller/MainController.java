package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.community.Community;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CommunityController controller;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    @GetMapping("/clientregister")
    public String clientRegister() {
        return "clientRegister";
    }

    @GetMapping("/ownerregister")
    public String ownerRegister() {
        return "ownerRegister";
    }

    @GetMapping("/joinsuccess")
    public String joinSuccess() {
        return "joinSuccess";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/clientlogin")
    public String clientlogin() {
        return "clientlogin";
    }

    @GetMapping("/ownerlogin")
    public String ownerlogin() {
        return "ownerlogin";
    }

    @GetMapping("/header")
    public String header() {
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }

    @GetMapping("/nearsite")
    public String nearSite() {
        return "nearSite";
    }

    @GetMapping("/weather")
    public String weather() {
        return "weather";
    }

    @GetMapping("/viewCampsite")
    public String viewCampsite() {
        return "viewCampsite";
    }

    @GetMapping("/community")
    public String community(Model model) {

        List<Community> list = controller.getAllCommunity();
        model.addAttribute("list", list);

        return "community";
    }

    // 게시판 글 작성하는 페이지
    @GetMapping("/communityclientwrite")
    public String communityClientWrite() {
        return "communityClientWrite";
    }

    @GetMapping("/communityownerwrite")
    public String communityOwnerWrite() {
        return "communityOwnerWrite";
    }

    @GetMapping("/modifyclient")
    public String modifyClient() {
        return "modifyClient";
    }

    @GetMapping("/modifyowner")
    public String modifyOwner() {
        return "modifyOwner";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/ownerSales")
    public String ownerSales() {
        return "ownerSales";
    }

    @GetMapping("/mypageclient")
    public String mypageClient() {
        return "mypageClient";
    }

    @GetMapping("/mypageowner")
    public String mypageOwner() {
        return "mypageOwner";
    }

}