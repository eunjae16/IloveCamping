package com.example.iluvcamping.domain.MonthlySalesbyOwner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monthly_sales_by_owner")
@Entity
public class MonthlySalesByOwner {

    @Id
    private String id;

    private String salesYear;
    private String month;
    private int totalSales;
    private String ownerCode;

}
