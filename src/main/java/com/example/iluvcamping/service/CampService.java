package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CampService {
    public final CampRepository campRepository;
    public final CampViewRepository campViewRepository;

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
}