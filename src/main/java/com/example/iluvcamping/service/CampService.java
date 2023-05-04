package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CampService {
    public final CampRepository campRepository;
    public final CampViewRepository campViewRepository;

    public List<CampView> getCampAll(){ return campViewRepository.findAll();}

    public List<Camp>searchCamp(String query){
        // 검색값이 포함되어 있는 게시글을 가져옴
        List<Camp> searchCamps = campRepository.findByCampNameContainingOrCampAddress1Containing(query, query);

        return searchCamps;
    }
}