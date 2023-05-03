package com.example.iluvcamping.controller;

import com.example.iluvcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // Owner 탈퇴
    @GetMapping("/regist/leave/owner")
    public String leaveOwnerByCode(@RequestParam String ownerCode){
        memberService.deleteOwnerByCode(ownerCode);

        return "index";
    }


}
