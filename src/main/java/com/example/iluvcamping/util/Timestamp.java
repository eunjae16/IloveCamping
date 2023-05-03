package com.example.iluvcamping.util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//@EntityListeners(AutoCloseable.class)
@EntityListeners(AuditingEntityListener.class)
public class Timestamp {

    @CreatedDate
    private LocalDateTime registeredDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
