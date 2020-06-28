package ru.gibdd.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gibdd.course.entity.Penalty;
import ru.gibdd.course.pojo.PenaltyByDriverLicense;
import ru.gibdd.course.repository.PenaltyRepository;
import ru.gibdd.course.util.GeneratePdfReport;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private PenaltyRepository penaltyRepository;

    @GetMapping("/")
    public String main(Model model) {
        Boolean search = false;
        model.addAttribute("search", search);
        return "index";
    }


    @PostMapping("/")
    public String search(@RequestParam String searchParam, @RequestParam String typeSearch, Model model)  {
        Iterable<Penalty> penalty;
        if(typeSearch.equals("License")) {
            penalty = penaltyRepository.findPenaltyByDriverLicense(searchParam);
            model.addAttribute("penalty", penalty);
            model.addAttribute("License", searchParam);
        }
        else if(typeSearch.equals("INN")) {
            penalty = penaltyRepository.findPenaltyByINN(searchParam);
            model.addAttribute("penalty", penalty);
            model.addAttribute("INN", searchParam);
        }
        else if(typeSearch.equals("State_number")) {
            penalty = penaltyRepository.findPenaltyByStateNumber(searchParam);
            model.addAttribute("penalty", penalty);
            model.addAttribute("State_number", searchParam);
        }



        return "index";
    }

    @GetMapping("/penalty/{decreeNumber}")
    public String penaltyDetails(@PathVariable String decreeNumber, Model model) {
        if(!penaltyRepository.existsById(decreeNumber)) {
            return "redirect:/";
        }
        Iterable<PenaltyByDriverLicense> penalty = penaltyRepository.findPenaltyInfoByDecreeNumber(decreeNumber);
//        Optional<Post> post = postRepository.findById(id);
//        ArrayList<Post> res = new ArrayList<>();
//        post.ifPresent(res::add);
        model.addAttribute("penalty", penalty);
        return "penalty-info";
    }

//    @RequestMapping(value = "/penalty/{decreeNumber}/report", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_PDF_VALUE)
    @GetMapping("/penalty/{decreeNumber}/report")
    public ResponseEntity<InputStreamResource> penaltyByRiverLicenseReport(@PathVariable String decreeNumber) {
        Iterable<PenaltyByDriverLicense> penaltys = penaltyRepository.findPenaltyInfoByDecreeNumber(decreeNumber);
        ByteArrayInputStream bis = GeneratePdfReport.penaltyByRiverLicenseReport(penaltys);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
