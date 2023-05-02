package com.example.iluvcamping.domain.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {
    private String clientCode;
    private String clientId;
    private String clientNickname;
    private String clientPassword;
    private String clientPhone;
    private String clientEmail;
    private String address;
    private String addressCode;
}
