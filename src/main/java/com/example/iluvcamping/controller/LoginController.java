package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.admin.Admin;
import com.example.iluvcamping.domain.admin.AdminRepository;
import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
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
    private final OwnerRepository ownerRepository;
    private final AdminRepository adminRepository;

    @PostMapping("/clientlogin")
    public String clientlogin(@RequestParam String id, @RequestParam String password, HttpSession session) {
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

    @PostMapping("/ownerlogin")
    public String ownerlogin(@RequestParam String id, @RequestParam String password, HttpSession session) {
        List<Owner> owners = ownerRepository.getAllByOwnerIdAndOwnerPassword(id, password);
        Owner loggedInOwner;
        if (owners.isEmpty()) {
            return "redirect:/login"; // 로그인 실패 시 다시 로그인 페이지로 리디렉션
        } else {
            loggedInOwner = owners.get(0);

            session.setAttribute("log", loggedInOwner);
            session.setAttribute("usertype", "owner");
            return "redirect:/"; // 로그인 성공 시 홈페이지로 리디렉션
        }
    }

    @PostMapping("/adminlogin")
    public String adminlogin(@RequestParam String id, @RequestParam String password, HttpSession session) {
        List<Admin> admins = adminRepository.getAllByAdminIdAndAdminPassword(id, password);

        if (admins.isEmpty()) {
            return "redirect:/login"; // 로그인 실패 시 다시 로그인 페이지로 리디렉션
        } else {
            Admin loggedInAdmin = admins.get(0);

            // 아이디와 비밀번호와 일치하는 데이터를 세션에 저장
            session.setAttribute("log", loggedInAdmin);
            session.setAttribute("usertype", "admin");

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