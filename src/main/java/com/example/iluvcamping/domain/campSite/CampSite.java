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
    private int siteMinPerson;
    private int siteMaxPerson;
    private int sitePrice;

    private Integer siteExtraPersonPrice;
    private Integer siteExtraCarabanPrice;

    private String campsiteImage;

    private boolean booked;

    public CampSite(String siteCode, String campCode, String siteName, int siteMinPerson, int siteMaxPerson, int sitePrice, String campsiteImage, boolean booked) {
        this.siteCode = siteCode;
        this.campCode = campCode;
        this.siteName = siteName;
        this.siteMinPerson = siteMinPerson;
        this.siteMaxPerson = siteMaxPerson;
        this.sitePrice = sitePrice;
        this.siteExtraPersonPrice = null;
        this.siteExtraCarabanPrice = null;
        this.campsiteImage = null;
        this.booked = booked;
    }

    public CampSite(CampSiteRequestDTO campSiteRequestDTO){
        this.siteCode = "";
        this.campCode = campSiteRequestDTO.getCampCode();
        this.siteName = campSiteRequestDTO.getSiteName();
        this.siteMinPerson = campSiteRequestDTO.getSiteMinPerson();
        this.siteMaxPerson = campSiteRequestDTO.getSiteMaxPerson();
        this.sitePrice = campSiteRequestDTO.getSitePrice();
        this.siteExtraPersonPrice = campSiteRequestDTO.getSiteExtraPersonPrice();
        this.siteExtraCarabanPrice = campSiteRequestDTO.getSiteExtraCarabanPrice();
        this.campsiteImage = campSiteRequestDTO.getCampsiteImage();
        this.booked = campSiteRequestDTO.isBooked();
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

}