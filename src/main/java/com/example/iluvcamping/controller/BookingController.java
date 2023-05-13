package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.booking.Booking;
import com.example.iluvcamping.domain.booking.BookingRepository;
import com.example.iluvcamping.domain.booking.BookingRequestDTO;
import com.example.iluvcamping.domain.bookingInfo.BookingInfoRequestDTO;
import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campFacilityView.CampFacilityViewRepository;
import com.example.iluvcamping.domain.campSite.CampSite;
import com.example.iluvcamping.domain.campSite.CampSiteRepository;
import com.example.iluvcamping.domain.campSurroundView.CampSurroundViewRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import com.example.iluvcamping.service.BookingService;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final CampRepository campRepository;
    private final CampFacilityViewRepository campFacilityViewRepository;
    private final CampSurroundViewRepository campSurroundViewRepository;
    private final CampThemeNameRepository campThemeNameRepository;
    private final CampSiteRepository campSiteRepository;
    private final KeyGenerator keyGenerator;
    private final BookingService bookingService;
    private final BookingRepository bookingRepository;

    @GetMapping("/get/campdetail")
    @ResponseBody
    public Camp getCampByCode(@RequestParam String campCode){

        Camp camp = campRepository.getCampByCampCode(campCode);

        return camp;
    }

    @PostMapping("/post/goreservation")
    public String goReservation(@RequestParam("campCode") String campCode, Model model){
        CampThemeName camp = campThemeNameRepository.getCampThemeNameByCampCode(campCode);
        if(camp != null){
            List<CampSite> campsite = campSiteRepository.getAllByCampCode(campCode);
            model.addAttribute("camp", camp);
            model.addAttribute("campsite", campsite);
            return "/booking/bookingCamp";
        }
        else return "error";
    }

    @GetMapping("/get/campsite/list")
    @ResponseBody
    public List<CampSite> getCampSiteListByCampCode(@RequestParam String campCode, Model model){
        List<CampSite> list = campSiteRepository.getAllByCampCode(campCode);

        return list;
    }

    // create booking
    @PostMapping("/get/reservation/info")
    public String getBookingInfo(@RequestBody BookingInfoRequestDTO bookingRequest, Model model){

        String bookingCode = "";
        String userCode = bookingRequest.getUserCode();
        String startDate = bookingRequest.getStartDate();
        String endDate = bookingRequest.getEndDate();
        String campCode = bookingRequest.getCampCode();
        String campsiteCode = bookingRequest.getCampSiteCode();

        String extraPerson = bookingRequest.getExtraPerson();
        String extraCaraban = bookingRequest.getExtraCaraban();

        CampSite campSite = campSiteRepository.getCampSiteBySiteCode(campsiteCode);
        Camp camp = campRepository.getCampByCampCode(campCode);

        // day price
        String day = bookingRequest.getDay();
        int pricePerDay = campSite.getSitePrice();

        // extra price
        int extraPersonPrice = campSite.getSiteExtraPersonPrice() * Integer.parseInt(extraPerson);
        int extraCarabanPrice = campSite.getSiteExtraPersonPrice() * Integer.parseInt(extraCaraban);

        int totalPrice = pricePerDay * (Integer.parseInt(day) - 1) + extraPersonPrice + extraCarabanPrice;

        Booking booking = new Booking(bookingCode,userCode,startDate,endDate,campCode,campsiteCode,totalPrice,Integer.parseInt(extraPerson),Integer.parseInt(extraCaraban));

        model.addAttribute("booking", booking);
        model.addAttribute("camp", camp);

        return "booking/checkBookingInfo";
    }

    @PostMapping("/regist/reservation" )
    public String createReservation(@RequestParam BookingRequestDTO bookingDto){
        Booking booking = new Booking(bookingDto);
        String code = keyGenerator.randomKey("K");
        booking.setBookingCode(code);

        bookingRepository.save(booking);

        return "booking/bookingSuccess";
    }


}
