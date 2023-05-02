package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRequestDTO;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRequestDTO;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class RegistController {

    private final com.example.iluvcamping.service.ClientService clientService;
    private final com.example.iluvcamping.service.OwnerService ownerService;
    private final KeyGenerator keyGenerator;

    // Join / Create

    @PostMapping("/regist/client")
    public String joinClient(@RequestBody ClientRequestDTO clientDto, HttpSession session) {
        Client client = new Client(clientDto);
        String code = keyGenerator.randomKey("A");
        client.setClientCode(code);
        clientService.addClient(client);

        session.setAttribute("usertype" , "client");
        session.setAttribute("log" , client);

        return "joinSuccess";
    }

    @PostMapping("/regist/owner")
    public String joinOwner (@RequestBody OwnerRequestDTO ownerDto, HttpSession session){
        Owner owner = new Owner(ownerDto);
        String code = keyGenerator.randomKey("B");
        owner.setOwnerCode(code);
        ownerService.addOwner(owner);

        session.setAttribute("usertype" , "owner");
        session.setAttribute("log" , owner);

        return "joinSuccess";
    }

}
