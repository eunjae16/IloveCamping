package com.example.iluvcamping.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampRepository extends JpaRepository<Camp, String> {
    List<Camp> findByCampAddress1StartingWith(String addressPrefix);
}

