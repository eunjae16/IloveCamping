package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.domain.community.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunityService {

    private final CommunityRepository communityRepository;

    // update
    @Transactional
    @PutMapping("updateCommunity")
    public void updateByWriteCode(Community newcommunity) {
        Community community =
                communityRepository.getReferenceById(newcommunity.getWriteCode());

        if(community != null) {
            community.setCommunity(newcommunity);
        }
    }

    public List<Community> getCommunityWithPage(SpringDataWebProperties.Pageable pageable) {
        return communityRepository.findAll((Pageable) pageable).getContent();
    }


    // delete
    @Transactional
    @DeleteMapping("/community/delete")
    public void deleteByWriteCode(String writeCode) {
        Community community =
                communityRepository.getCommunitiesByWriteCode(writeCode);

        if(community != null) {
            communityRepository.deleteById(community.getWriteCategoryCode());
        }
    }

}
