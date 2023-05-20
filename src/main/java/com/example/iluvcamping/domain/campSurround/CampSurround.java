package com.example.iluvcamping.domain.campSurround;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="camp_surround")
@Entity
public class CampSurround {
    @Id
    private String campCode;
    private String surroundName;

}
