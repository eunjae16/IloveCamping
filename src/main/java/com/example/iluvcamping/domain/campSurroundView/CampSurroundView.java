package com.example.iluvcamping.domain.campSurroundView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "camp_surround_view")
@Entity
public class CampSurroundView {
    private String campCode;
    @Id
    private String surroundCategoryName;
}
