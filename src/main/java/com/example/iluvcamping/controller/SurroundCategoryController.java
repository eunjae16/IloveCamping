package com.example.iluvcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SurroundCategoryController {

    private final SurroundCategoryRepository surroundCategoryRepository;


    // Create

    @GetMapping("/surroundCategory/add")
    public void addSurroundCategory(SurroundCategory surroundCategory) {
        surroundCategoryRepository.save(surroundCategory);
    }


    // Read [ all ]

    @GetMapping("/surroundCategory/readall")
    public List<SurroundCategory> getSurroundCategoryAll(){
        return surroundCategoryRepository.findAll();
    }


    // Read [ findOne ]
    @GetMapping("/surroundCategory/readone")
    public SurroundCategory getSurroundCategoryBySurroundCategoryCode(String surroundCategoryCode) {
        SurroundCategory surroundCategory = null;

        surroundCategory = surroundCategoryRepository.findById(surroundCategoryCode).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 코드입니다.")
        );

        return surroundCategory;
    }



}
