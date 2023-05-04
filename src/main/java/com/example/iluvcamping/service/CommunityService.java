package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import com.example.iluvcamping.domain.community.CommunityRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommunityService {

    private final CommunityRepository communityRepository;

    // update
    @Transactional
    public void updateByWriteCode(Community newcommunity) {
        Community community = communityRepository.findById(newcommunity.getWriteCode()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다.")
        );
        community.setCommunity(newcommunity);
    }

    @PutMapping("/community/ownerupdate")
    public void updateCommunityOwner(@RequestBody CommunityRequestDTO communityDto) {
        Community community = new Community(communityDto);
        System.out.println("ommunity/ownerupdate : " + community.getContent());
        updateByWriteCode(community);
    }


    // 페이징처리
    public List<Community> getCommunityWithPage(Pageable pageable) {
        return communityRepository.findAll(pageable).getContent();
    }


    // delete
    @Transactional
    @DeleteMapping("/community/delete")
    public void deleteByWriteCode(String writeCode) {
        Community community =
                communityRepository.getCommunityByWriteCode(writeCode);

        if(community != null) {
            communityRepository.deleteById(community.getWriteCategoryCode());
        }
    }

}
