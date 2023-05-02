package com.example.iluvcamping.domain.campFacility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="camp_facility")
public class CampFacility {

    private String campCode;
    private String campFacilityCode;


//    public CampFacility(CampFacility)

}





