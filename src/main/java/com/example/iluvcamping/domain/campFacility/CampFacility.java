package com.example.iluvcamping.domain.campFacility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="camp_facility")
@Entity
public class CampFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String campCode;
    private String campFacilityCode;

    public CampFacility(CampFacilityRequestDTO campFacilityRequestDTO) {
        this.campCode = campFacilityRequestDTO.getCampCode();
        this.campFacilityCode = campFacilityRequestDTO.getCampFacilityCode();
    }


}





