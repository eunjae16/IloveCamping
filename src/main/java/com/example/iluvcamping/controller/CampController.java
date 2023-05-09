package com.example.iluvcamping.controller;

import com.example.iluvcamping.domain.camp.Camp;
import com.example.iluvcamping.domain.camp.CampRepository;
import com.example.iluvcamping.domain.campView.CampView;
import com.example.iluvcamping.domain.campView.CampViewRepository;
import com.example.iluvcamping.service.CampService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CampController {

    private final CampRepository campRepository;
    private final CampViewRepository campViewRepository;
    private final CampService campService;

    public CampController(CampRepository campRepository, CampViewRepository campViewRepository, CampService campService) {
        this.campRepository = campRepository;
        this.campService = campService;
        this.campViewRepository = campViewRepository;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<CampView> searchCampsites(@RequestParam(value = "site", required = false) String site, @RequestParam(value = "query", required = false) String query) {
        // select 옵션 선택 시 campView에 있는 campAddress1의 맨 처음 두 글자가 일치하면 일치하는 데이터들을 모두 찾음
        List<CampView> campViews = new ArrayList<>();
        if (site != null && site.equals("address")) {
            if (query != null) {
                List<CampView> selectedCamps = campViewRepository.findAllByCampAddress1StartingWith(query.substring(0, 2));
                for (CampView campView : selectedCamps) {
                    if (campView.getCampName().contains(site)) {
                        campViews.add(campView);
                    }
                }
            }
        } else if (site != null && site.equals("name")) {
            if (query != null) {
                List<Camp> searchedCamps = campService.searchCamp(query);
                for (Camp camp : searchedCamps) {
                    List<CampView> foundCamps = campViewRepository.findAllByCampName(camp.getCampName());
                    campViews.addAll(foundCamps);
                }
            }
        }
        return campViews;
    }

    @GetMapping("/campsite/search")
    public String searchCamp(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Camp> searchCamps = new ArrayList<>();
        if (query != null && !query.isEmpty()) {
            searchCamps = campService.searchCamp(query);
        }
        model.addAttribute("camps", searchCamps);
        return "viewCampsite";
    }


    @PostMapping("/campsite/search")
    public ResponseEntity<List<Camp>> searchCamps(@RequestBody String query) {
        List<Camp> camps = campService.searchCamp(query);
        return new ResponseEntity<>(camps, HttpStatus.OK);
    }

    @GetMapping("/getCampAll")
    @ResponseBody
    public List<CampView> getCampAll() {
        List<Object[]> camps = campViewRepository.findAllCamps();
        List<CampView> campViews = new ArrayList<>();
        for (Object[] camp : camps) {
            CampView campView = new CampView();
            campView.setCampName((String) camp[0]);
            campView.setCampImage((String) camp[1]);
            campView.setCampAddress1((String) camp[2]);
            campView.setCampTheme((String) camp[3]);

            campViews.add(campView);
        }
        return campViews;
    }

    @GetMapping("/camp/{name}")
    public ResponseEntity<CampView> getCamp(@PathVariable String name) {
        CampView campView = campViewRepository.findById(name).orElse(null);
        if (campView == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(campView, HttpStatus.OK);
    }


    // 지도에 표시할 목적의 모든 camp read
    @ResponseBody
    @GetMapping("/camp/readall")
    public List<Camp> getCampListAll()  {
        return campRepository.findAll();
    }
}

