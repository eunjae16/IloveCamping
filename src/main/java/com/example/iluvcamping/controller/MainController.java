package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.community.Community;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CommunityController controller;
    private final CampController campController;

    @GetMapping("/")
    public String index() {
        return "sementic/index";
    }

    @GetMapping("/regist")
    public String regist() {
        return "register/regist";
    }

    @GetMapping("/clientregister")
    public String clientRegister() {
        return "register/clientRegister";
    }

    @GetMapping("/ownerregister")
    public String ownerRegister() {
        return "register/ownerRegister";
    }

    @GetMapping("/joinsuccess")
    public String joinSuccess() {
        return "register/joinSuccess";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/clientlogin")
    public String clientlogin() {
        return "login/clientlogin";
    }

    @GetMapping("/ownerlogin")
    public String ownerlogin() {
        return "login/ownerlogin";
    }

    @GetMapping("/header")
    public String header() {
        return "sementic/header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "sementic/footer";
    }

    @GetMapping("/nearsite")
    public String nearSite() {
        return "camp/nearSite";
    }

    @GetMapping("/weather")
    public String weather() {
        return "camp/weather";
    }

    @GetMapping("/viewcampsite")
    public String viewCampsite() {
        return "camp/viewCampsite";
    }

    @GetMapping("/community")
    public String community(Model model) {

        List<Community> list = controller.getAllCommunity();
        model.addAttribute("list", list);

        return "community/community";
    }

    // 게시판 글 작성하는 페이지
    @GetMapping("/communityclientwrite")
    public String communityClientWrite() {
        return "community/communityClientWrite";
    }

    @GetMapping("/communityownerwrite")
    public String communityOwnerWrite() {
        return "community/communityOwnerWrite";
    }

    @GetMapping("/modifyclient")
    public String modifyClient() {
        return "mypage/modifyClient";
    }

    @GetMapping("/modifyowner")
    public String modifyOwner() {
        return "mypage/modifyOwner";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/ownerSales")
    public String ownerSales() {
        return "mypage/ownerSales";
    }

    @GetMapping("/mypageclient")
    public String mypageClient() {
        return "mypage/mypageClient";
    }

    @GetMapping("/mypageowner")
    public String mypageOwner() {
        return "mypage/mypageOwner";
    }

    @GetMapping("/byebye")
    public String byebye() {
        return "register/byebye";
    }

    @GetMapping("/campdetail")
    public String campDetailPage() {
        return "camp/campDetailPage";
    }

    @GetMapping("/camplist")
    public String campList(Model model) {

        List<CampThemeName> list = campController.getCampListAll();
        model.addAttribute("list", list);

        return "camp/campList";
    }

    @GetMapping("/bookingcamp")
    public String bookingCamp(){
        return "booking/bookingCamp";
    }


    @GetMapping("/ownerCampRegist")
    public String ownerCampRegist() {
        return "mypage/ownerCampRegist";
    }

}