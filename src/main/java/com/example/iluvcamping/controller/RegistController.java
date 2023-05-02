package com.example.iluvcamping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RegistController {

    private final com.example.campsite.service.ClientService clientService;
    private final com.example.campsite.service.OwnerService ownerService;
    private final KeyGenerator keyGenerator;

    // Join / Create

    @PostMapping("/regist/client")
    public String joinClient(@RequestBody ClientRequestDTO clientDto, HttpSession session) {
        Client client = new Client(clientDto);
        String code = keyGenerator.randomKey("A");
        client.setClientCode(code);
        clientService.addClient(client);

        System.out.println("name : " + clientDto.getClientNickname());

//        session.setAttribute("log", client);
//        session.setAttribute("logType", "client");

        return "joinSuccess";
    }


//    @PostMapping("/regist/owner")
//    public String joinOwner(@RequestBody OwnerRequestDTO ownerDto) {
//        Owner owner = new Owner(ownerDto);
//        String code = keyGenerator.randomKey("B");
//        owner.setOwnerCode(code);
//        ownerService.addOwner(owner);
//
//        return "login";
//    }

    @PostMapping("/regist/owner")
    public String joinOwner(
            @RequestParam String id,
            @RequestParam String password,
            @RequestParam String nickname,
            @RequestParam String account
            , HttpServletRequest request) throws ServletException, IOException {
        Owner owner = new Owner("",id,password,nickname,account);
        String code = keyGenerator.randomKey("B");
        owner.setOwnerCode(code);
        ownerService.addOwner(owner);

        request.setAttribute("log", owner);
        request.setAttribute("logtype", "owner");

        System.out.println(request.getAttribute("logtype"));

        return "/";
    }

}
