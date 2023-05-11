package com.example.iluvcamping.domain.categoryCount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category_count")
@Entity
public class CategoryCount {
    @Id
    @Column(name = "category_code")
    private String categoryCode;
    @Column(name = "count")
    private String count;
}
