package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRequestDTO;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@SessionAttributes
@Controller
@RequiredArgsConstructor
public class RegistController {

    private final com.example.iluvcamping.service.ClientService clientService;
    private final com.example.iluvcamping.service.OwnerService ownerService;
    private final KeyGenerator keyGenerator;

    // Join / Create

    @SessionScope
    @PostMapping("/regist/client")
    public String joinClient(@RequestBody ClientRequestDTO clientDto, Model model) {
        Client client = new Client(clientDto);
        String code = keyGenerator.randomKey("A");
        client.setClientCode(code);
        clientService.addClient(client);

        System.out.println("name : " + clientDto.getClientNickname());

        model.addAttribute("log", client);
        model.addAttribute("logType", "client");

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
