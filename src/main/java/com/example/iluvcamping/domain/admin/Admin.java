package com.example.iluvcamping.domain.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "admin")
@Entity
public class Admin {
    @Id
    @Column(name = "admin_code")
    private String adminCode;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "admin_nickname")
    private String adminNickName;

    @Column(name = "admin_password")
    private String adminPassword;
}
