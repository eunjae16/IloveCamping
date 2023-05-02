package com.example.iluvcamping.domain.communityCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="community_category")
public class CommunityCategory {
    @Id
    private String communityCategoryCode;

    private String communityCategoryName;

    public CommunityCategory (CommunityCategoryRepository communityCategoryDto) {
        this.communityCategoryCode = communityCategoryDto.getCommunityCategoryCode();
        this.communityCategoryName = communityCategoryDto.getCommunityCategoryName();
    }

    public void setCommunityCategory(CommunityCategory communityCategory) {
        this.communityCategoryCode = communityCategory.getCommunityCategoryCode();
        this.communityCategoryName = communityCategory.getCommunityCategoryName();
    }

}
