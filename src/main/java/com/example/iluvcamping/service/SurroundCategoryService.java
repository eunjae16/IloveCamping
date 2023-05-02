package com.example.iluvcamping.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SurroundCategoryService {

    private final SurroundCategoryRepository surroundCategoryRepository;


    // update
    public void updateBySurroundCategoryCode(SurroundCategory newSurroundCategory) {
        SurroundCategory surroundCategory =
                surroundCategoryRepository.getSurroundCategoryBySurroundCategoryCode(newSurroundCategory.getSurroundCategoryCode());

        if (surroundCategory != null) {
            surroundCategory.setSurroundCategory(newSurroundCategory);
        }
    }



    // delete
    public void deleteBySurroundCategoryCode(String surroundCategoryCode) {
        SurroundCategory surroundCategory =
                surroundCategoryRepository.getSurroundCategoryBySurroundCategoryCode(surroundCategoryCode);

        if(surroundCategory != null) {
            surroundCategoryRepository.deleteById(surroundCategory.getSurroundCategoryCode());
        }
    }



}
