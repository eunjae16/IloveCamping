package com.example.iluvcamping.domain.campSurround;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="camp_surround")
public class CampSurround {
    private String campCode;
    private String surroundName;

}
