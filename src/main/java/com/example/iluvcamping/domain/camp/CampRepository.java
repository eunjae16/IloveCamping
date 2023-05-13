package com.example.iluvcamping.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRepository extends JpaRepository<Camp, String> {
    List<Camp> findByCampNameContainingOrCampAddress1Containing(String name, String address);

    public List<Camp> getAllByCampOwner(String campOwnerCode);

    public void deleteCampByCampOwner(String ownerCode);

    public List<Camp> findAll();

    public Camp getCampByCampCode(String campCode);

}

