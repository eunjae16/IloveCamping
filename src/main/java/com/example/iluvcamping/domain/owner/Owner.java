package com.example.iluvcamping.domain.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="owner")
@Entity
public class Owner {

    @Id
    private String ownerCode;

    @Column(name="owner_id")
    private String ownerId;

    @Column(name="owner_nickname")
    private String ownerNickname;

    @Column(name="owner_password")
    private String ownerPassword;
    private String account;

    public Owner(OwnerRequestDTO ownerDto){
        this.ownerCode = "";
        this.ownerId = ownerDto.getOwnerId();
        this.ownerNickname = ownerDto.getOwnerNickname();
        this.ownerPassword = ownerDto.getOwnerPassword();
        this.account = ownerDto.getAccount();
    }

    public void setOwnerCode(String ownerCode){
        this.ownerCode = ownerCode;
    }

}
