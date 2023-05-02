package com.example.iluvcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunityController extends Timestamp {

    private final CommunityRepository communityRepository;
    private final CommunityService communityService;


    // create

//    public String addCommunity(@RequestBody )

//    @PostMapping("/community/add")
//    public void addCommunity(Community community) {
//        communityRepository.save(community);
//    }


    // read [ all ]
    @GetMapping("/community/readall")
    public List<Community> getAllCommunity(){
        return communityRepository.findAll();
    }




    // read [ one ] > 글 찾는 api 를 만들기만 해준 기능 !  > 메인컨트롤러에서 이 메소드사용해서 처리해줘야함 !
    @GetMapping("/community/readone")
    public Community getCommunityByWriteCode(@RequestParam String writeCode) {
        Community community = communityRepository.getCommunitiesByWriteCode(writeCode);
        System.out.println(community.getTitle());
        return community;
    }




    // paging
    @GetMapping("/community/page")
    public List<Community> getCommunityPage(@PageableDefault(sort={"writeCode"}, direction = Sort.Direction.DESC)Pageable pageable) {
        return communityService.getCommunityWithPage(pageable.withPage(1));
    }



}
