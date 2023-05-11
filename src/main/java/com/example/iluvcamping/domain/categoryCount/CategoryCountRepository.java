package com.example.iluvcamping.domain.categoryCount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryCountRepository extends JpaRepository<CategoryCount, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM category_count WHERE categoryCode=:categoryCode")
    public List<CategoryCount> getCategoryCountByCategoryCode(@Param("categoryCode") String categoryCode);

    public List<CategoryCount> findAll();
}
