package com.example.iluvcamping.domain.booking;

import com.example.iluvcamping.domain.bookingVIew.BookingView;
import com.example.iluvcamping.domain.camp.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,String> {

    public List<Booking> getAllByUserCode(String clientCode);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE booking SET user_code = '00000000' WHERE user_code = :usercode")
    public void updateBookingByUserCode(@Param("usercode") String usercode);

    public List<Booking> getBookingByUserCode (String clientCode);


}
