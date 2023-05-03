package com.example.iluvcamping.controller;

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

    private final MonthlySalesByOwnerRepository monthlySalesByOwnerRepository;
    @GetMapping("/get/allmonthlylist")
    @ResponseBody // json 타입의 객체를 반환한다~
    // 반환된 애를 js 주물주물하던가~ 아무튼 값을
    public  List<MonthlySalesByOwner> getAllMonthlySales() {
        List<MonthlySalesByOwner> list = monthlySalesByOwnerRepository.findAll();

        return list;
    }

    @GetMapping("/get/monthlysales/ownercode")
    @ResponseBody
    public List<MonthlySalesByOwner> getMonthlySalesByOwner(@RequestParam String ownerCode){
        List<MonthlySalesByOwner> list = monthlySalesByOwnerRepository.getMonthlySalesByOwnersByOwnerCode(ownerCode);

        return list;
    }

}
