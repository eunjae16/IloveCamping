package com.example.iluvcamping.domain.reply;

import com.example.iluvcamping.domain.community.Community;
import com.example.iluvcamping.util.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reply")
@Entity
public class Reply extends Timestamp {

    @Id
    private String replyCode;

    private String writeCode;
    private String comment;
    private String replierNickname;

    private boolean modifiedCheck;

    public Reply(ReplyRequestDTO replyDto){
        this.writeCode = replyDto.getWriteCode();
        this.replyCode = replyDto.getReplyCode();
        this.comment = replyDto.getComment();
        this.replierNickname = replyDto.getReplierNickname();
        this.modifiedCheck = replyDto.isModifiedCheck();
    }



    public void setReplyCode(String replyCode){
        this.replyCode = replyCode;
    }

    // 댓글 수정여부 체크설정
    public void setModifiedCheck(boolean modifiedCheck) {this.modifiedCheck = modifiedCheck; }

    public void updateReply(ReplyRequestDTO replyDto) {
        this.comment = replyDto.getComment();
    }

}
