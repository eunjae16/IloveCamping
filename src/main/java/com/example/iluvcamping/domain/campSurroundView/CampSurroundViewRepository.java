package com.example.iluvcamping.domain.campSurroundView;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampSurroundViewRepository extends JpaRepository<CampSurroundView, String> {
    public List<CampSurroundView> findAllByCampCode(String campCode);
}
