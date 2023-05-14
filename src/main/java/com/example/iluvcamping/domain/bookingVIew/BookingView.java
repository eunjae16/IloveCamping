package com.example.iluvcamping.domain.bookingVIew;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking_view")
@Entity
public class BookingView {
    @Id
    private String bookingCode;
    private String campImage;
    private String campName;
    private String siteName;
    private String startDate;
    private String endDate;
    private String totalPrice;
    private String userCode;


}
