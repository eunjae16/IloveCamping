package com.example.iluvcamping.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRepository extends JpaRepository<Camp, String> {
    List<Camp> findByCampAddress1StartingWith(String addressPrefix);

    List<Camp> findByCampNameContainingOrCampAddress1Containing(String name, String address);
}

