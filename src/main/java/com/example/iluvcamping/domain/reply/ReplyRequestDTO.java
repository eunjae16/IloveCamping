package com.example.iluvcamping.domain.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequestDTO {

    private String replyCode;

    private String writeCode;
    private String comment;
    private String replierNickname;
    private String registeredDate;
    private String modifiedDate;
    private boolean modifiedCheck;

}
