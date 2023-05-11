package com.example.iluvcamping.domain.themeView;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeViewRepository extends JpaRepository<ThemeView, String> {
    List<ThemeView> findByThemeName(String themeName);
}
