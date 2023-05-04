package com.example.iluvcamping.domain.campView;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampViewRepository extends JpaRepository<CampView, String> {
    List<CampView> findAllByCampAddress1StartingWith(String addressPrefix);
}