package com.example.iluvcamping.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CampService {
    public final CampRepository campRepository;

    public List<Camp> getCampAll(){
        return campRepository.findAll();
    }
}