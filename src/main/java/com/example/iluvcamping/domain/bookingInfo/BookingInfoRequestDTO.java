package com.example.iluvcamping.domain.bookingInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfoRequestDTO {

    private String userCode;
    private String campCode;
    private String startDate;
    private String endDate;
    private String day;
    private String extraPerson;
    private String extraCaraban;
    private String campSiteCode;

}
