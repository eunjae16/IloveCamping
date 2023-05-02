package com.example.iluvcamping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunityCategoryController {

    private final CommunityCategoryRepository communityCategoryRepository;
    // create

    @PostMapping("/communityCategory/add")
    public void addCommunityCategory(CommunityCategory communityCategory) {
        communityCategoryRepository.save(communityCategory);
    }

    // read all
    public List<CommunityCategory> getAllCommunityCategory(){
        return communityCategoryRepository.findAll();
    }

    // read one
    @GetMapping("/facilityCategory/readone")
    public CommunityCategory getCommunityCategoryByCommunityCategoryCode(String communityCategoryCode){

        CommunityCategory communityCategory = null;

        communityCategory = communityCategoryRepository.findById(communityCategoryCode).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 코드입니다.")
        );

        return communityCategory;
    }



}
