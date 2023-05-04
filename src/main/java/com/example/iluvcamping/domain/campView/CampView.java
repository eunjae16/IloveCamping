package com.example.iluvcamping.domain.campView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Table(name = "camp_view")
@Entity
public class CampView {
    @Id
    @Column(name = "camp_name")
    private String campName;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "camp_image")
    private String campImage;
    @Column(name = "camp_address1")
    private String campAddress1;
    @Column(name = "camp_theme")
    private String campTheme;
}