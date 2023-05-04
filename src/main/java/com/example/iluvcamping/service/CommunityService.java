package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunityService {

    private final CommunityRepository communityRepository;

    // update
    @Transactional
    @PutMapping("/community/update")
    public void updateByWriteCode(Community newcommunity) {
        Community community =
                communityRepository.getReferenceById(newcommunity.getWriteCode());

        if(community != null) {
            community.setCommunity(newcommunity);
        }
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
