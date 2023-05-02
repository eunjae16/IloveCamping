package com.example.iluvcamping.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampRepository extends JpaRepository<com.example.iluvcamping.domain.camp.Camp, String> {
    List<com.example.iluvcamping.domain.camp.Camp> findByCampAddress1StartingWith(String addressPrefix);
}

