package com.example.iluvcamping.domain.community;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "community_view")
public class CommunityView {
    @Id
    private String writeCode;

    private String writerNickname;
    private String communityCategoryName;
    private String title;
    private String content;
    private String bookingCode;

}
