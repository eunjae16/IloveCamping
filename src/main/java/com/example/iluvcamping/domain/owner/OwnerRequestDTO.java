package com.example.iluvcamping.domain.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequestDTO {
    private String ownerCode;
    private String ownerId;
    private String ownerNickname;
    private String ownerPassword;
    private String account;
}
