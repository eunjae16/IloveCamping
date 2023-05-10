package com.example.iluvcamping.domain.campSite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampSiteRequestDTO {

    private String siteCode;

    private String campCode;
    private String siteName;
    private int siteMinPerson;
    private int siteMaxPerson;
    private int sitePrice;

    private Integer siteExtraPersonPrice;
    private Integer siteExtraCarabanPrice;

    private String campsiteImage;
}
