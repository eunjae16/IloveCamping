package com.example.iluvcamping.domain.community;

import com.example.iluvcamping.util.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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


    public Community(CommunityRequestDTO communityDto) {
        this.writeCode = "";
        this.writerNickname = communityDto.getWriterNickname();
        this.writeCategoryCode = communityDto.getWriteCategoryCode();
        this.title = communityDto.getTitle();
        this.content = communityDto.getContent();
        this.bookingCode = communityDto.getBookingCode();
    }

    public void setWriteCode(String writeCode) {
        this.writeCode = writeCode;
    }

    public void setCommunity(Community community) {
        this.writeCode = community.getWriteCode();
        this.writerNickname = community.getWriterNickname();
        this.writeCategoryCode = community.getWriteCategoryCode();
        this.title = community.getTitle();
        this.content = community.getContent();
        this.bookingCode = community.getBookingCode();
    }

}
