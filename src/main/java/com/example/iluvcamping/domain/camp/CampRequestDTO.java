package com.example.iluvcamping.domain.camp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CampRequestDTO {
    private String campCode;
    private String campOwner;
    private String campName;
    private String campImage;
    private String campAddressCode;
    private String campAddress1;
    private String campPhone;
    private double x;
    private double y;
}
