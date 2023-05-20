package com.example.iluvcamping.domain.camp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampRegistRequestDTO {

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
    private String[] facilityCodes;
    private String surroundCategoryCode;

}
