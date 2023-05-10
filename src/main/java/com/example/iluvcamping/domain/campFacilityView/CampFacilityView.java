package com.example.iluvcamping.domain.campFacilityView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "camp_facility_view")
@Entity
public class CampFacilityView {
    private String campCode;
    @Id
    private String categoryName;
    private String facilityImgUrl;
}
