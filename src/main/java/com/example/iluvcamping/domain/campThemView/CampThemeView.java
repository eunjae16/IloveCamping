package com.example.iluvcamping.domain.campThemView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "camp_theme_view")
public class CampThemeView {
    @Column(name = "camp_code")
    private String campCode;

    @Column(name = "theme_name")
    private String themeName;
}
