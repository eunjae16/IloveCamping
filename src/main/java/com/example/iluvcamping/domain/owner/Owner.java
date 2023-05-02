package com.example.iluvcamping.domain.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String ownerId;
    private String ownerNickname;
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
