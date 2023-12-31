package com.example.iluvcamping.controller;


import com.example.iluvcamping.domain.campTheme.CampTheme;
import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import com.example.iluvcamping.domain.community.CommunityRequestDTO;
import com.example.iluvcamping.service.CommunityService;
import com.example.iluvcamping.util.KeyGenerator;
import com.example.iluvcamping.util.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunityController extends Timestamp {

    private final CommunityRepository communityRepository;
    private final CommunityService communityService;
    private final KeyGenerator keyGenerator;

    // create
    @PostMapping("/community/add")
    public void addCommunity(Community community) {
        communityRepository.save(community);
    }


    // write [ community ]
  @PostMapping("/community/write")
    public String communityClientWrite(@RequestBody CommunityRequestDTO communityDto) {
        Community community = new Community(communityDto);
        String code = keyGenerator.randomKey("H");
        community.setWriteCode(code);

        addCommunity(community);

        return "community";
    }


    // read [ all ]
    @GetMapping("/community/readall")
    public List<Community> getAllCommunity(){
        return communityRepository.findAll();
    }


    // read [ one ] > 글 찾는 api 를 만들기만 해준 기능 !  > 메인컨트롤러에서 이 메소드사용해서 처리해줘야함 !
    @GetMapping("/community/readone")
    public Community getCommunityByWriteCode(@RequestParam String writeCode) {
        Community community = communityRepository.getCommunityByWriteCode(writeCode);
        return community;
    }

    // update
    @PutMapping("/community/update")
    public void updateByWriteCode(@RequestBody CommunityRequestDTO communityDto) {
            communityService.updateCommunity(communityDto);
    }

    // delete [ owner ]
    @DeleteMapping("/community/deletewrite")
    public void removeWrite(String writeCode) {
        Community community = getCommunityByWriteCode(writeCode);
        communityService.deleteWriteByWritecode(writeCode);
    }

    // paging
    @GetMapping("/community/page")
    public Page<Community> getCommunityPage(@PageableDefault(page=0 ,size = 10, sort={"registeredDate"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return communityService.getCommunityWithPage(pageable);
    }

}
