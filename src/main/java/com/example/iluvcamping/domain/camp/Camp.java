package com.example.iluvcamping.domain.camp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Table(name = "camp")
@Entity
public class Camp {
    @Id
    @Column(name = "camp_code")
    private String campCode;
    @NonNull
    @Column(name = "camp_owner")
    private String campOwner;
    @NonNull
    @Column(name = "camp_name")
    private String campName;
    @NonNull
    @Column(name = "camp_image")
    private String campImage;
    @NonNull
    @Column(name = "camp_address_code")
    private String campAddressCode;
    @NonNull
    @Column(name = "camp_address1")
    private String campAddress1;
    @NonNull
    @Column(name = "camp_phone")
    private String campPhone;

}