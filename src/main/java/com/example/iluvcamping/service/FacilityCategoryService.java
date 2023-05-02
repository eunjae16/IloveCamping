package com.example.iluvcamping.service;

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
