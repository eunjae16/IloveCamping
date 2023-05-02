package com.example.iluvcamping.domain.campSurround;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CampSurroundRequestDTO {
    private String campCode;
    private String surroundCode;
}
