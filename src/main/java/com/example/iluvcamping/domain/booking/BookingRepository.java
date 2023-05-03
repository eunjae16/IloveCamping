package com.example.iluvcamping.domain.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,String> {

    public List<Booking> getBookingsByUserCode(String clientCode);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Booking b SET b.user_code = '00000000' WHERE b.user_code = :usercode")
    public void updateBookingsByWriterNickname(@Param("usercode") String usercode);

}
