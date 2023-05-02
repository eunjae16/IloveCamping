package com.example.iluvcamping.domain.codeCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CodeCategoryRequestDTO {
    private String codeTag;

    private String codeName;
}
