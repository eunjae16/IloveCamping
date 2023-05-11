package com.example.iluvcamping.domain.themeView;

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
@Table(name = "theme_view")
@Entity
public class ThemeView {
    @Id
    @Column(name = "camp_code")
    private String campCode;
    @Column(name = "camp_name")
    private String campName;
    @Column(name = "camp_image")
    private String campImage;
    @Column(name = "camp_phone")
    private String campPhone;
    @Column(name = "theme_name")
    private String themeName;
    @Column(name = "camp_address")
    private String campAddress;

}
