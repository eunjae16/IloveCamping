package com.example.iluvcamping.domain.community;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community , String> {

    public Community getCommunityByWriteCode(String writeCode);

    public List<Community> getCommunitiesByWriterNickname(String nickname);
}
