package com.example.iluvcamping.domain.campSite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "camp_site")
@Entity
public class CampSite {

    @Id
    private String siteCode;

    private String campCode;
    private String siteName;
    private Integer siteExtraPersonPrice;
    private Integer siteExtraCarabanPrice;
    private Integer siteMinPerson;
    private Integer siteMaxPerson;
    private Integer sitePrice;

    public CampSite(String siteCode, String campCode, String siteName, int siteMinPerson, int siteMaxPerson, int sitePrice) {
        this.siteCode = siteCode;
        this.campCode = campCode;
        this.siteName = siteName;
        this.siteMinPerson = siteMinPerson;
        this.siteMaxPerson = siteMaxPerson;
        this.sitePrice = sitePrice;
    }
}

