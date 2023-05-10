package com.example.iluvcamping.domain.campTheme;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "camp_theme")
@Entity
public class CampTheme {
    @Id
    private String themeCode;
    private String themeName;
}