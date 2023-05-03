package com.example.iluvcamping.service;


import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campThemView.CampThemeView;
import com.example.iluvcamping.domain.campThemView.CampThemeViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CampService {
    public final CampRepository campRepository;
    public final CampThemeViewRepository campThemeViewRepository;

    public List<Camp> getCampAll(){
        return campRepository.findAll();
    }
    public List<CampThemeView> getViewAllById(List<String> ids){
        return campThemeViewRepository.findAllById(ids);
    }
}