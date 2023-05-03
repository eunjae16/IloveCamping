package com.example.iluvcamping.domain.MonthlySalesbyOwner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonthlySalesByOwnerRepository extends JpaRepository<MonthlySalesByOwner, String> {

    @Query(nativeQuery = true ,value = "SELECT * FROM monthly_sales_by_owner WHERE owner_code=:ownerCode")
    public List<MonthlySalesByOwner> getMonthlySalesByOwnersByOwnerCode(@Param("ownerCode") String ownerCode);

}
