package com.example.iluvcamping.domain.facilityCategory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacilityCategoryRequestDTO {
    @JsonProperty("category_code")
    private String categoryCode;
    @JsonProperty("category_name")
    private String categoryName;
}
