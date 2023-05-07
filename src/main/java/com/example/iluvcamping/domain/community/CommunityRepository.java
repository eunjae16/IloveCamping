package com.example.iluvcamping.domain.community;

import com.example.iluvcamping.domain.communityCategory.CommunityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community , String> {

    public Community getCommunityByWriteCode(String writeCode);

    public List<Community> getAllByWriterNickname(String nickname);


    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Community c SET c.writerNickname = '탈퇴한회원' WHERE c.writerNickname = :nick")
    public void updateCommunitiesByWriterNickname(@Param("nick") String nick);


}
