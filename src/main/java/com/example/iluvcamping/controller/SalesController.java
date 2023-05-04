package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.DailySalesByOwner.DailySalesByOwner;
import com.example.iluvcamping.domain.DailySalesByOwner.DailySalesByOwnerRepository;
import com.example.iluvcamping.domain.MonthlySalesbyOwner.MonthlySalesByOwner;
import com.example.iluvcamping.domain.MonthlySalesbyOwner.MonthlySalesByOwnerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class SalesController {

    private final DailySalesByOwnerRepository dailySalesByOwnerRepository;
    private final MonthlySalesByOwnerRepository monthlySalesByOwnerRepository;

    @GetMapping("/get/allmonthlylist")
    @ResponseBody
    public List<MonthlySalesByOwner> getAllMonthlySales() {
        List<MonthlySalesByOwner> list = monthlySalesByOwnerRepository.findAll();

        return list;
    }

    @GetMapping("/get/monthlysales/ownercode")
    @ResponseBody
    public List<MonthlySalesByOwner> getMonthlySalesByOwner(@RequestParam String ownerCode){
        List<MonthlySalesByOwner> list = monthlySalesByOwnerRepository.getMonthlySalesByOwnersByOwnerCode(ownerCode);

        return list;
    }

    @GetMapping("/get/dailysales/ownercode")
    @ResponseBody
    public List<DailySalesByOwner> getDailySalesByOwner(@RequestParam String ownerCode) {
        List <DailySalesByOwner> list = dailySalesByOwnerRepository.getDailySalesByOwnerByOrderByOwnerCode(ownerCode);

        return list;
    }

}
