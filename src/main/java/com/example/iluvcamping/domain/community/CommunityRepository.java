package com.example.iluvcamping.domain.community;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community , String> {

    public Community getCommunitiesByWriteCode(String writeCode);
}
