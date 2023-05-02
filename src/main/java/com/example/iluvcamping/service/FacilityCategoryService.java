package com.example.iluvcamping.service;

import com.example.iluvcamping.controller.FacilityCategoryController;
import com.example.iluvcamping.domain.facilityCategory.FacilityCategory;
import com.example.iluvcamping.domain.facilityCategory.FacilityCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FacilityCategoryService {

    private final FacilityCategoryRepository facilityCategoryRepository;
    public final FacilityCategoryController facilityCategoryController;

    // update

    @Transactional
    public void updateById(FacilityCategory newFacilityCategory){
        FacilityCategory facilityCategory =
                facilityCategoryController.getFacilityCategoryByCategoryCode(newFacilityCategory.getCategoryCode());

        if(facilityCategory != null) {
            facilityCategory.setFacility(newFacilityCategory);
        }
    }


    // delete

    @Transactional
    public void deleteById(String categoryCode) {
        FacilityCategory facilityCategory =
                facilityCategoryController.getFacilityCategoryByCategoryCode(categoryCode);

        if (facilityCategory != null) {
            facilityCategoryRepository.deleteById(facilityCategory.getCategoryCode());
        }
    }
}
