package com.example.iluvcamping.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {

    private String bookingCode;

    private String userCode;
    private String startDate;
    private String endDate;
    private String campCode;
    private String campsiteCode;
    private int totalPrice;
    private int extraPerson;
    private int extraCaraban;
}
