package com.example.iluvcamping.domain.campThemeName;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampThemeNameRepository extends JpaRepository<CampThemeName, String> {

    public CampThemeName getCampThemeNameByCampCode(String campCode);

    // [지역카테고리] 만으로 검색결과
    public List<CampThemeName> findAllByCampAddress1ContainingAndCampNameContaining(String region, String content);

}
