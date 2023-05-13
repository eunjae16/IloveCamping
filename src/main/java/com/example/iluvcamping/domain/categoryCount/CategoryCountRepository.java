package com.example.iluvcamping.domain.categoryCount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryCountRepository extends JpaRepository<CategoryCount, String> {

    public List<CategoryCount> findAll();

    @Query("SELECT c.categoryCount FROM CategoryCount c WHERE c.campCategoryCode = :categoryCode")
    String getCategoryCountByCategoryCode(String categoryCode);
}
