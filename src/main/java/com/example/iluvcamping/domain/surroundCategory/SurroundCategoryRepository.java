package com.example.iluvcamping.domain.surroundCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurroundCategoryRepository extends JpaRepository<SurroundCategory, String> {

    public SurroundCategory getSurroundCategoryBySurroundCategoryCode(String surroundCategoryCode);
}
