package com.example.iluvcamping.domain.themeView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeViewRepository extends JpaRepository<ThemeView, String> {
    List<ThemeView> findByThemeName(String themeName);

    @Query("SELECT tv FROM ThemeView tv WHERE tv.themeName <> '캠핑' ORDER BY tv.themeName")
    List<ThemeView> findDistinctByThemeNameNotCampfireOrderByThemeName();
}
