package com.example.iluvcamping.domain.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="client")
@Entity
public class Client {
    @Id
    private String clientCode;

    private String clientId;
    private String clientNickname;
    private String clientPassword;
    private String clientPhone;
    private String clientEmail;
    private String address;
    private String addressCode;

    public Client(ClientRequestDTO clientDto){
        this.clientCode = "";
        this.clientId = clientDto.getClientId();
        this.clientNickname = clientDto.getClientNickname();
        this.clientPassword = clientDto.getClientPassword();
        this.clientPhone = clientDto.getClientPhone();
        this.clientEmail = clientDto.getClientEmail();
        this.address = clientDto.getAddress();
        this.addressCode = clientDto.getAddressCode();
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public void setClientNickname(String nickname) {
        this.clientNickname = nickname;
    }

    public void setClientPassword(String password){
        this.clientPassword = password;
    }

    public void setClientPhone(String phone){
        this.clientPhone = phone;
    }

    public void setClientEmail(String email){
        this.clientEmail = email;
    }

    public void setAddressCode(String addressCode){
        this.addressCode = addressCode;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
