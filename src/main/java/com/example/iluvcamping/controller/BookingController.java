package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.booking.Booking;
import com.example.iluvcamping.domain.booking.BookingRepository;
import com.example.iluvcamping.domain.booking.BookingRequestDTO;
import com.example.iluvcamping.domain.bookingInfo.BookingInfoRequestDTO;
import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campSite.CampSite;
import com.example.iluvcamping.domain.campSite.CampSiteRepository;
import com.example.iluvcamping.domain.campThemeName.CampThemeName;
import com.example.iluvcamping.domain.campThemeName.CampThemeNameRepository;
import com.example.iluvcamping.domain.client.ClientRepository;
import com.example.iluvcamping.util.KeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final CampRepository campRepository;
    private final CampThemeNameRepository campThemeNameRepository;
    private final CampSiteRepository campSiteRepository;
    private final KeyGenerator keyGenerator;
    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;

    @GetMapping("/get/campdetail")
    @ResponseBody
    public Camp getCampByCode(@RequestParam String campCode) {

        Camp camp = campRepository.getCampByCampCode(campCode);

        return camp;
    }

    @PostMapping("/post/goreservation")
    public String goReservation(@RequestParam("campCode") String campCode, Model model) {
        CampThemeName camp = campThemeNameRepository.getCampThemeNameByCampCode(campCode);
        if (camp != null) {
            List<CampSite> campsite = campSiteRepository.getAllByCampCode(campCode);
            model.addAttribute("camp", camp);
            model.addAttribute("campsite", campsite);
            return "/booking/bookingCamp";
        } else return "error";
    }

    @GetMapping("/get/campsite/list")
    @ResponseBody
    public List<CampSite> getCampSiteListByCampCode(@RequestParam String campCode, Model model) {
        List<CampSite> list = campSiteRepository.getAllByCampCode(campCode);

        return list;
    }

    // create booking
    @PostMapping("/get/reservation/info")
    public String getBookingInfo(@RequestBody BookingInfoRequestDTO bookingRequest, HttpSession session) {

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

        if (camp == null)
            System.out.println("camp is null");

        // day price
        String day = bookingRequest.getDay();
        int pricePerDay = campSite.getSitePrice();

        // extra price
        int extraPersonPrice = campSite.getSiteExtraPersonPrice() * Integer.parseInt(extraPerson);
        int extraCarabanPrice = campSite.getSiteExtraPersonPrice() * Integer.parseInt(extraCaraban);

        int totalPrice = pricePerDay * (Integer.parseInt(day) - 1) + extraPersonPrice + extraCarabanPrice;

        Booking booking = new Booking(bookingCode, userCode, startDate, endDate, campCode,
                campsiteCode, totalPrice, Integer.parseInt(extraPerson), Integer.parseInt(extraCaraban));

        session.setAttribute("booking", booking);
        session.setAttribute("camp", camp);

        return "booking/checkBookingInfo";
    }

    @PostMapping("/get/bookingInfo")
    public ResponseEntity<BookingInfoRequestDTO> getBookingInfoTest(@RequestBody BookingInfoRequestDTO bookingRequest) {

        Camp camp = campRepository.getCampByCampCode(bookingRequest.getCampCode());

        if (camp == null)
            return ResponseEntity.notFound().build();

        BookingInfoRequestDTO bookingResponse = new BookingInfoRequestDTO();

        bookingResponse.setUserCode(bookingRequest.getUserCode());
        bookingResponse.setCampCode(camp.getCampCode());
        bookingResponse.setStartDate(bookingRequest.getStartDate());
        bookingResponse.setEndDate(bookingRequest.getEndDate());
        bookingResponse.setDay(bookingRequest.getDay());
        bookingResponse.setExtraPerson(bookingRequest.getExtraPerson());
        bookingResponse.setExtraCaraban(bookingRequest.getExtraCaraban());
        bookingResponse.setCampSiteCode(bookingRequest.getCampSiteCode());

        return ResponseEntity.ok(bookingResponse);
    }


    @PostMapping("/regist/reservation")
    public String createReservation(@ModelAttribute BookingRequestDTO bookingDto) {
        Booking booking = new Booking(bookingDto);

        String code = keyGenerator.randomKey("J");
        booking.setBookingCode(code);

        bookingRepository.save(booking);

        return "booking/bookingSuccess";
    }

    @GetMapping("/booking/cancle")
    public String deleteBookingInfo(HttpSession session) {
        session.removeAttribute("booking");
        session.removeAttribute("camp");

        return "/sementic/index";
    }


    @GetMapping("/booking/readlist")
    public String bookingList(@RequestParam("clientCode") String clientCode, Model model) {
        System.out.println("clientCode:" +clientCode);

        List<Booking> bookingList = bookingRepository.getBookingByUserCode(clientCode);
        List<Camp> campList = new ArrayList<>();
        List<CampSite> siteList = new ArrayList<>();

        for(Booking booking : bookingList){
            String campCode = booking.getCampCode();
            String siteCode = booking.getCampsiteCode();

            Camp camp = campRepository.getCampByCampCode(campCode);
            CampSite campSite = campSiteRepository.getCampSiteBySiteCode(siteCode);

            campList.add(camp);
            siteList.add(campSite);
        }


        model.addAttribute("bookingList", bookingList);
        model.addAttribute("campList", campList);

        return "booking/bookingList";
    }

}