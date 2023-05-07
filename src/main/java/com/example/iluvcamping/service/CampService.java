package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CampService {
    public final CampRepository campRepository;
    public final CampViewRepository campViewRepository;

    @GetMapping("/getCampAll")
    @ResponseBody
    public List<CampView> getCampAll() {
        List<Object[]> camps = campViewRepository.findAllCamps();
        List<CampView> campViews = new ArrayList<>();
        for (Object[] camp : camps) {
            String campName = (String) camp[0];
            String categoryName = (String) camp[1];

            CampView campView = new CampView();
            campView.setCampName(campName);
            campView.setCategoryName(categoryName);
            campView.setCampImage((String) camp[2]);
            campView.setCampAddress1((String) camp[3]);
            campView.setCampTheme((String) camp[4]);
            campViews.add(campView);
        }
        return campViews;
    }


    public List<Camp>searchCamp(String query){
        // 검색값이 포함되어 있는 게시글을 가져옴
        List<Camp> searchCamps = campRepository.findByCampNameContainingOrCampAddress1Containing(query, query);

        return searchCamps;
    }
}