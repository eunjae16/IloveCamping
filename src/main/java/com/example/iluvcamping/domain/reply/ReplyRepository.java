package com.example.iluvcamping.domain.reply;

import com.example.iluvcamping.domain.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, String> {

    public List<Reply> getRepliesByReplierNickname(String nickname);

    public List<Reply> findByWriteCode(String writeCode);

    public Reply getReplyByReplyCode(String replyCode);

    @Modifying
    @Query(nativeQuery = true, value="UPDATE Reply r SET r.replierNickname = '탈퇴한회원' WHERE r.repierNickname =: nick")
    public void updateRepliesByReplierNickname(@Param("nick") String nick);
}
