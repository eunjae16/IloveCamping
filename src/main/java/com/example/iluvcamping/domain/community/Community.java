package com.example.iluvcamping.domain.community;

import com.example.iluvcamping.domain.reply.Reply;
import com.example.iluvcamping.util.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.aop.AfterReturningAdvice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name="community")
public class Community extends Timestamp {
    @Id
    private String writeCode;

    private String writerNickname;
    private String writeCategoryCode;
    private String title;
    private String content;
    private String bookingCode;

//
//    @OneToMany(mappedBy = "community" , cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Reply> replyList = new ArrayList<>();

    public Community(CommunityRequestDTO communityDto) {
        this.writeCode = communityDto.getWriteCode();
        this.writerNickname = communityDto.getWriterNickname();
        this.writeCategoryCode = communityDto.getWriteCategoryCode();
        this.title = communityDto.getTitle();
        this.content = communityDto.getContent();
        this.bookingCode = communityDto.getBookingCode();
    }

    public void setWriteCode(String writeCode) {
        this.writeCode = writeCode;
    }

    public void updateCommunity(CommunityRequestDTO communityDto) {
        this.title = communityDto.getTitle();
        this.content = communityDto.getContent();
    }

}
