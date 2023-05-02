package com.example.iluvcamping.domain.codeCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="code_category")
public class CodeCategory {
    @Id
    private String codeTag;

    private String codeName;

    public CodeCategory(CodeCategoryRequestDTO codeCategoryRequestDto) {
        this.codeTag = codeCategoryRequestDto.getCodeTag();
        this.codeName = codeCategoryRequestDto.getCodeName();
    }

    public void setCodeCategory(CodeCategory codeCategory) {
        this.codeTag = codeCategory.getCodeTag();
        this.codeName = codeCategory.getCodeName();
    }
}
