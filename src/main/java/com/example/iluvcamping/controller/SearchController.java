package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class SearchController {

    private final CampRepository campRepository;

    @ResponseBody
    @GetMapping("/search/camp")
    public List<Camp> searchCamp(@RequestParam String query){
        List<Camp> list = campRepository.findByCampNameContainingOrCampAddress1Containing(query,query);

        return list;
    }

}
