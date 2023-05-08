package com.example.iluvcamping.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, String> {

    public List<Reply> getAllByReplierNickname(String nickname);

    public List<Reply> findByWriteCode(String writeCode);

    public Reply getReplyByReplyCode(String replyCode);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE reply SET replier_nickname = '탈퇴한회원' WHERE replier_nickname=:nick")
    public void updateReplyByReplierNickname(@Param("nick") String nick);

}

