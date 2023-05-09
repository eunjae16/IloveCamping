package com.example.iluvcamping.domain.camp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(name = "camp_code")
    private String campCode;
    @Column(name = "camp_owner")
    private String campOwner;
    @Column(name = "camp_name")
    private String campName;
    @Column(name = "camp_image")
    private String campImage;
    @Column(name = "camp_address_code")
    private String campAddressCode;
    @Column(name = "camp_address1")
    private String campAddress1;
    @Column(name = "camp_phone")
    private String campPhone;
    private double x;
    private double y;




}