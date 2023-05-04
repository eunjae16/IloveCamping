package com.example.iluvcamping.domain.DailySalesByOwner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DailySalesByOwnerRepository  extends JpaRepository<DailySalesByOwner, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM daily_sales_by_owner WHERE owner_code=:ownerCode")
    public List<DailySalesByOwner> getDailySalesByOwnerByOrderByOwnerCode(@Param("ownerCode") String ownerCode);

}
