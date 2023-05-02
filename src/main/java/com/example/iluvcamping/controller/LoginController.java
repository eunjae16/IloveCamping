package com.example.iluvcamping.controller;


import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    public LoginController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpSession session) {
        List<Client> clients = clientService.getClientAllByIdAndPassword(id, password);

        if (clients.isEmpty()) {
            return "redirect:/login"; // 로그인 실패 시 다시 로그인 페이지로 리디렉션
        } else {
            Client loggedInClient = clients.get(0);
            session.setAttribute("loggedInClient", loggedInClient);
            return "redirect:/"; // 로그인 성공 시 홈페이지로 리디렉션
        }
    }
}
