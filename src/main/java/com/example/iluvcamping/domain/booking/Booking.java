package com.example.iluvcamping.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
@Entity
public class Booking {

    @Id
    private String bookingCode;

    private String userCode;
    private String startDate;
    private String endDate;
    private String campCode;
    private int totalPrice;
    private int extraPerson;

    public Booking(BookingRequestDTO bookingDto){
        this.bookingCode = "";
        this.userCode = bookingDto.getUserCode();
        this.startDate = bookingDto.getStartDate();
        this.endDate = bookingDto.getEndDate();
        this.campCode = bookingDto.getCampCode();
        this.totalPrice = bookingDto.getTotalPrice();
        this.extraPerson = bookingDto.getExtraPerson();
    }

    public void setBookingCode(String bookingCode){
        this.bookingCode = bookingCode;
    }

}
