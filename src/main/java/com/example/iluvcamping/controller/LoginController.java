package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final ClientRepository clientRepository;

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
        List<Client> clients = clientRepository.getAllByClientIdAndClientPassword(id, password);

        if (clients.isEmpty()) {
            return "redirect:/login"; // 로그인 실패 시 다시 로그인 페이지로 리디렉션
        } else {
            Client loggedInClient = clients.get(0);

            // 아이디와 비밀번호와 일치하는 데이터를 세션에 저장
            session.setAttribute("log", loggedInClient);
            session.setAttribute("usertype", "client");

            return "redirect:/"; // 로그인 성공 시 홈페이지로 리디렉션
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("log"); // 세션에서 "log" 속성 삭제
        session.removeAttribute("usertype"); // 세션에서 "usertype" 속성 삭제
        session.invalidate(); // 세션 무효화

        return "redirect:/"; // index.jsp로 리디렉션
    }
}
