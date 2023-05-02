package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.facilityCategory.FacilityCategory;
import com.example.iluvcamping.domain.facilityCategory.FacilityCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FacilityCategoryController {




    // 폼을 가져가서 값을 가져가야해 > 컨트롤롤러 하고 리퀘스트바디




    private final FacilityCategoryRepository facilityCategoryRepository;


    // create
    @PostMapping("/facilitycategory/add")
    public void addFacilityCategory(FacilityCategory facilityCategory) {
        facilityCategoryRepository.save(facilityCategory);
    }


    // read [ all ]
    @GetMapping("/facilitycategory/read")
    public List<FacilityCategory> getAllFacilityCategory(){
        return facilityCategoryRepository.findAll();
    }


    // read [ by id ]
    @GetMapping("/facilitycategory/readone")
    public FacilityCategory getFacilityCategoryByCategoryCode(String categoryCode){

        FacilityCategory facilityCategory = null;

        facilityCategory = facilityCategoryRepository.findById(categoryCode).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 코드입니다.")
        );

        return facilityCategory;
    }



}