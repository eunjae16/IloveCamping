package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.community.Community;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class CommunityViewController {

    private final CommunityController controller;


    // 게시글의 상세페이지로 이동 [ 1개의 클릭 게시물 ]
    @GetMapping("/communityread")
    public ModelAndView communityRead(@RequestParam String writeCode){
        Community community = controller.getCommunityByWriteCode(writeCode);

        ModelAndView modelAndView = new ModelAndView("communityread");
        modelAndView.addObject("community", community);

        return modelAndView;
    }


    // 수정을 위한 게시글 리로드 [ owner 용 ]
    @GetMapping("/editownerwrite")
    public ModelAndView editOwnerWrite(@RequestParam String writeCode) {
        Community community = controller.getCommunityByWriteCode(writeCode);

        ModelAndView modelAndView = new ModelAndView("editOwnerWrite");
        modelAndView.addObject("community" , community);

        return modelAndView;
    }



}
