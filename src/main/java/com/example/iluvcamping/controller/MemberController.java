package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.owner.OwnerRequestDTO;
import com.example.iluvcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // Owner 탈퇴
    @PostMapping("/register/leave/owner")
    public String leaveOwnerByCode(@RequestParam String ownerCode , HttpServletRequest request){
        memberService.deleteOwnerByCode(ownerCode);
        deleteSession(request);
        return "register/byebye";
    }

    // Client 탈퇴
    @PostMapping("/register/leave/client")
    public String leaveClientByCode(@RequestParam String clientCode, HttpServletRequest request){
        memberService.deleteClientByCode(clientCode);
        deleteSession(request);
        return "register/byebye";
    }

    public void deleteSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("log");
            session.removeAttribute("usertype");
        }
    }

    // Owner 수정
    @PostMapping("/modify/owner")
    public String updateOwnerByCode(@RequestBody OwnerRequestDTO updateOwner, @RequestParam String ownerCode){
        memberService.updateOwnerByCode(updateOwner,ownerCode);
        return "mypageowner";
    }

    // Client 수정


}
