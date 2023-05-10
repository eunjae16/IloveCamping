package com.example.iluvcamping.domain.campThemeName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Table(name = "camp_theme_name")
@Entity
public class CampThemeName {
    @Id
    private String campCode;

    private String campCategoryCode;
    private String campCategoryName;
    private String campOwner;
    private String campName;
    private String campImage;
    private String campAddressCode;
    private String campAddress1;
    private String campAddress2;
    private String campPhone;
}
