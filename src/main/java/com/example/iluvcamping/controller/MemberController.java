package com.example.iluvcamping.controller;

import com.example.iluvcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // Owner 탈퇴
    @GetMapping("/regist/leave/owner")
    public String leaveOwnerByCode(@RequestParam String ownerCode){
        memberService.deleteOwnerByCode(ownerCode);
        return "sementic/index";
    }

    // Client 탈퇴
    @PostMapping("/register/leave/client")
    public String leaveClientByCode(@RequestParam String clientCode){
        memberService.deleteClientByCode(clientCode);
        return "sementic/index";
    }


}
