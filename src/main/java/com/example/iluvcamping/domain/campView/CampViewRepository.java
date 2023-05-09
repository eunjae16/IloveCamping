package com.example.iluvcamping.domain.campView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampViewRepository extends JpaRepository<CampView, String> {
    List<CampView> findAllByCampAddress1StartingWith(String addressPrefix);

    @Query("SELECT camp.campName, camp.campImage, camp.campAddress1, camp.campTheme FROM CampView camp")
    List<Object[]> findAllCamps();
}
