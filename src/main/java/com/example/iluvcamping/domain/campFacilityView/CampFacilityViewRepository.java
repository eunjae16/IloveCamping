package com.example.iluvcamping.domain.campFacilityView;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampFacilityViewRepository extends JpaRepository<CampFacilityView, String> {
    public List<CampFacilityView> findAllByCampCode(String campCode);
    public List<CampFacilityView> getCampFacilityViewByCampCode(String campCode);
}
