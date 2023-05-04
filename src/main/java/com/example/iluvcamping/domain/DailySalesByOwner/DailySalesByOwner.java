package com.example.iluvcamping.domain.DailySalesByOwner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "daily_sales_by_owner")
@Entity
public class DailySalesByOwner {

    private String date;
    private int totalSales;

    @Id
    private String ownerCode;

}
