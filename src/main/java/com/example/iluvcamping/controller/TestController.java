package com.example.iluvcamping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @GetMapping("test")
    public String test(HttpSession session){
        session.setAttribute("check" , "hello");

        return "index";
    }
}
