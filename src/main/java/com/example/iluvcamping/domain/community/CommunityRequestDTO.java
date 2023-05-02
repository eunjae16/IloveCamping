package com.example.iluvcamping.domain.community;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommunityRequestDTO {
    private String writeCode;

    private String writerNickname;
    private String writeCategoryCode;
    private String title;
    private String content;
    private String registeredDate;
    private String modifiedDate;
    private String bookingCode;
}
