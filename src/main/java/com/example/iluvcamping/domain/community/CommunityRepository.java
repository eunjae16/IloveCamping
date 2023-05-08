package com.example.iluvcamping.domain.community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community , String> {

    public Community getCommunityByWriteCode(String writeCode);

    public List<Community> getAllByWriterNickname(String nickname);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE community SET writer_nickname = '탈퇴한회원' WHERE writer_nickname = :nick")
    public void updateCommunityByWriterNickname(@Param("nick") String nick);



}
