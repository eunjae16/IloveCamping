package com.example.iluvcamping.domain.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reply")
@Entity
public class Reply {

    @Id
    private String replyCode;

    private String writeCode;
    private String comment;
    private String replierNickname;
    private String registeredDate;
    private String modifiedDate;
    private Boolean modifiedCheck;

    public Reply(ReplyRequestDTO replyDto){
        this.replyCode = replyDto.getReplyCode();
        this.comment = replyDto.getComment();
        this.replierNickname = replyDto.getReplierNickname();
        this.registeredDate = replyDto.getRegisteredDate();
        this.modifiedDate = replyDto.getModifiedDate();
        this.modifiedCheck = replyDto.getModifiedCheck();
    }

    public void setReplyCode(String replyCode){
        this.replyCode = replyCode;
    }

}
