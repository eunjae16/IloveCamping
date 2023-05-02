package com.example.iluvcamping.service;


import com.example.iluvcamping.controller.CommunityCategoryController;
import com.example.iluvcamping.domain.communityCategory.CommunityCategory;
import com.example.iluvcamping.domain.communityCategory.CommunityCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommunityCategoryService {


    private final CommunityCategoryRepository communityCategoryRepository;
    private final CommunityCategoryController communityCategoryController;

    // update
    public void updateById(CommunityCategory newCommunityCategory) {
        CommunityCategory communityCategory =
                communityCategoryController.getCommunityCategoryByCommunityCategoryCode(newCommunityCategory.getCommunityCategoryCode());

        if(communityCategory != null) {
            communityCategory.setCommunityCategory(newCommunityCategory);
        }

    }


    // delete

    public void deleteById(String communityCategoryCode) {
        CommunityCategory communityCategory =
                communityCategoryController.getCommunityCategoryByCommunityCategoryCode(communityCategoryCode);

        if(communityCategory != null) {
            communityCategoryRepository.deleteById(communityCategory.getCommunityCategoryCode());
        }
    }

}
