package com.example.iluvcamping.domain.camp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Table(name = "camp")
@Entity
public class Camp {
    @Id
    private String campCode;
    private String campOwner;
    private String campCategoryCode;
    private String campName;
    private String campImage;
    private String campAddressCode;
    private String campAddress1;
    private String campAddress2;
    private String campPhone;
    private double x;
    private double y;

    public Camp(CampRequestDTO campDto){
        this.campCode = "";
        this.campOwner = campDto.getCampOwner();
        this.campCategoryCode = campDto.getCampCategoryCode();
        this.campName = campDto.getCampName();
        this.campImage = campDto.getCampImage();
        this.campAddressCode = campDto.getCampAddressCode();
        this.campAddress1 = campDto.getCampAddress1();
        this.campAddress2 = campDto.getCampAddress2();
        this.campPhone = campDto.getCampPhone();
        this.x = campDto.getX();
        this.y = campDto.getY();
    }

    public void setCampCode(String campCode){
        this.campCode = campCode;
    }

    public void updateCampName(CampRequestDTO campDto) {
        this.campName = campDto.getCampName();
    }


}