package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.camp.CampRequestDTO;
import com.example.iluvcamping.domain.campSite.CampSite;
import com.example.iluvcamping.domain.campSite.CampSiteRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CampService {
    public final CampRepository campRepository;
    public final CampViewRepository campViewRepository;
    public final CampSiteRepository campSiteRepository;

    public List<CampView> getCampsByAddressPrefix(String prefix) {
        return campViewRepository.findByCampAddress1StartingWith(prefix);
    }

    public List<CampView> getAllCamp() {
        return campViewRepository.findAll();
    }

    public List<Camp>searchCamp(String query){
        // 검색값이 포함되어 있는 게시글을 가져옴
        List<Camp> searchCamps = campRepository.findByCampNameContainingOrCampAddress1Containing(query, query);

        return searchCamps;
    }

    public void addCamp(Camp camp) { campRepository.save(camp); }

    public List<Camp> searchCampByKeyword(String keyword) {
        List<Camp> allCamps = campRepository.findAll();
        List<Camp> filteredCamps = new ArrayList<>();

        for (Camp camp : allCamps) {
            if (camp.getCampCode().contains(keyword) ||
                    camp.getCampOwner().contains(keyword) ||
                    camp.getCampCategoryCode().contains(keyword) ||
                    camp.getCampName().contains(keyword) ||
                    camp.getCampImage().contains(keyword) ||
                    camp.getCampAddressCode().contains(keyword) ||
                    camp.getCampAddress1().contains(keyword) ||
                    camp.getCampAddress2().contains(keyword) ||
                    camp.getCampPhone().contains(keyword)) {
                filteredCamps.add(camp);
            }
        }

        return filteredCamps;
    }

    public void addCampSite(CampSite campSite) { campSiteRepository.save(campSite); }

    // campName 변경
    @Transactional
    public void updateCamp(CampRequestDTO campDto) {
        String campCode = campDto.getCampCode();

        Camp camp = campRepository.findById(campCode).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 캠프코드입니다.")
        );

        camp.updateCampName(campDto);

    }

}