package com.example.iluvcamping.domain.campSite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampSiteRepository extends JpaRepository<CampSite, String> {

    public void deleteCampSiteByCampCode(String campCode);

    public List<CampSite> getAllByCampCode(String campCode);

}
