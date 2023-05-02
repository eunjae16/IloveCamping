package com.example.iluvcamping.domain.campFacility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CampFacilityRequestDTO {
    private String campCode;
    private String campFacilityCode;
}
