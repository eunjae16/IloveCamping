package com.example.iluvcamping.controller;


import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@SessionAttributes("loggedInClient")
public class SessionController {
    private final ClientRepository clientRepository;

    @GetMapping("/sessionInfo")
    public String sessionInfo(Model model, HttpSession session){
        Client loggedInClient = (Client) session.getAttribute("loggedInClient");
        model.addAttribute("client", loggedInClient);
        return "sessionInfo";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login"; // 로그아웃 시 다시 로그인 페이지로 리디렉션
    }
}
