package com.example.iluvcamping.domain.surroundCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="surround_category")
@Entity
public class SurroundCategory {
    @Id
    private String surroundCategoryCode;

    private String surroundCategoryName;



    public SurroundCategory(SurroundCategoryRequestDTO surroundCategoryDto) {
        this.surroundCategoryCode = surroundCategoryDto.getSurroundCategoryCode();
        this.surroundCategoryName = surroundCategoryDto.getSurroundCategoryName();
    }

    public void setSurroundCategory(SurroundCategory surroundCategory) {
        this.surroundCategoryCode = surroundCategory.getSurroundCategoryCode();
        this.surroundCategoryName = surroundCategory.getSurroundCategoryName();
    }
}
