package com.example.iluvcamping.domain.facilityCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="facility_category")
public class FacilityCategory {

    @Id
    private String categoryCode;

    private String categoryName;


    public FacilityCategory(FacilityCategoryRequestDTO facilityCategoryDto) {
        this.categoryCode = facilityCategoryDto.getCategoryCode();
        this.categoryName = facilityCategoryDto.getCategoryName();
    }


    public void setFacility(FacilityCategory facilityCategory) {
        this.categoryCode = facilityCategory.getCategoryCode();
        this.categoryName = facilityCategory.getCategoryName();
    }

}
