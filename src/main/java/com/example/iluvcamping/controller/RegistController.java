package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.client.Client;
import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.domain.client.ClientRequestDTO;
import com.example.iluvcamping.domain.owner.Owner;
import com.example.iluvcamping.domain.owner.OwnerRepository;
import com.example.iluvcamping.domain.owner.OwnerRequestDTO;
import com.example.iluvcamping.service.ClientService;
import com.example.iluvcamping.service.OwnerService;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class RegistController {

    private final ClientService clientService;
    private final OwnerService ownerService;
    private final KeyGenerator keyGenerator;

    private final ClientRepository clientRepository;
    private final OwnerRepository ownerRepository;

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

    @ResponseBody
    @RequestMapping("/regist/idcheck.action")
    public String checkId(@RequestParam("id") String id){
        Client client = clientRepository.getClientByClientId(id);
        Owner owner = ownerRepository.getOwnerByOwnerId(id);

        if(client == null && owner == null)
            return "0";
        else
            return "1";
    }

    @ResponseBody
    @RequestMapping("/regist/nicknamecheck.action")
    public String checkNickname(@RequestParam("nickname") String nickname){
        Client client = clientRepository.getClientByClientNickname(nickname);
        Owner owner = ownerRepository.getOwnerByOwnerNickname(nickname);

        if(client == null && owner == null)
            return "0";
        else return "1";
    }

    @ResponseBody
    @RequestMapping("/regist/idcheck/owner.action")
    public String checkIdOwner(@RequestParam("id") String id){
        Client client = clientRepository.getClientByClientId(id);
        Owner owner = ownerRepository.getOwnerByOwnerId(id);

        if(client == null && owner == null)
            return "0";
        else
            return "1";
    }

    @ResponseBody
    @RequestMapping("/regist/nicknamecheck/owner.action")
    public String checkNicknameOwner(@RequestParam("nickname") String nickname){
        Client client = clientRepository.getClientByClientNickname(nickname);
        Owner owner = ownerRepository.getOwnerByOwnerNickname(nickname);

        if(client == null && owner == null)
            return "0";
        else
            return "1";
    }





}
