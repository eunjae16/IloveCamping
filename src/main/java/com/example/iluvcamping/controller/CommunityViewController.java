package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.reply.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class CommunityViewController {

    private final CommunityController controller;


    // 게시글의 상세페이지로 이동 [ 1개의 클릭 게시물 의 정보 + 리플리스트 들고 옴 ]
    @GetMapping("/communityread")
    public ModelAndView communityRead(@RequestParam String writeCode){
        Community community = controller.getCommunityByWriteCode(writeCode);
//        Reply reply = controller.getReplyByWriteCode(writeCode);

        ModelAndView modelAndView = new ModelAndView("communityread");
        modelAndView.addObject("community", community);
//        modelAndView.addObject("reply" , reply);

        return modelAndView;
    }


    // 수정을 위한 게시글 리로드 [ owner 용 ]
    @GetMapping("community/editowner")
    public ModelAndView editOwnerWrite(@RequestParam String writeCode) {
        Community community = controller.getCommunityByWriteCode(writeCode);

        ModelAndView modelAndView = new ModelAndView("community/editOwner");
        modelAndView.addObject("community" , community);

        return modelAndView;
    }

    // 수정을 위한 게시글 리로드 [ client 용 ]
    @GetMapping("community/editclient")
    public ModelAndView editClient(@RequestParam String writeCode) {
        Community community = controller.getCommunityByWriteCode(writeCode);

        ModelAndView modelAndView = new ModelAndView("community/editClient");
        modelAndView.addObject("community" , community);

        return modelAndView;
    }



}
