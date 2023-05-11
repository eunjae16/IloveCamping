package com.example.iluvcamping.domain.categoryCount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryCountRepository extends JpaRepository<CategoryCount, String> {

    public List<CategoryCount> findAll();

    @Query(nativeQuery = true, value = "SELECT SUM(count) AS total_count FROM category_count")
    Long getTotalCount();

}
