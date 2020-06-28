package ru.gibdd.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.gibdd.course.entity.Gibdd;
import ru.gibdd.course.entity.Penalty;
import ru.gibdd.course.pojo.PenaltyByDriverLicense;
import ru.gibdd.course.repository.GibddRepository;
import ru.gibdd.course.repository.PenaltyRepository;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;

//import java.sql.Date;
import java.util.Date;
import java.util.UUID;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PenaltyRepository penaltyRepository;

//    @Value("${upload.path}")
//    private String uploadPath;

    @GetMapping
    public String adminMain(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Penalty> penalty = penaltyRepository.findAll();
        if (filter != null && !filter.isEmpty()) {
            penalty = penaltyRepository.findByDecreeNumber(filter);
        } else {
            penalty = penaltyRepository.findAll();
        }

        model.addAttribute("penalty", penalty);
        model.addAttribute("filter", filter);
        return "admin";
    }

    @GetMapping("/add")
    public String penaltyAddPage(Model model) {
        return "penalty-add";
    }


    @PostMapping("/add")
    public String penaltyAdd(
            @RequestParam String decreeNumber,
            @RequestParam String Certificate_number,
            @RequestParam Long Camera_number,
            @RequestParam String Article,
            @RequestParam(name = "Date_time_penalty") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date_time_penalty,
            @RequestParam(defaultValue="false") boolean Paid,
            @RequestParam String Penalty_size,
            @RequestParam String Place_of_violation,
            Model model)  {

        Penalty penalty = new Penalty(
                decreeNumber,
                Certificate_number,
                Camera_number,
                Article,
                Date_time_penalty,
                Penalty_size,
                Paid,
                Place_of_violation
        );

        penaltyRepository.save(penalty);

        return "redirect:/admin";
    }

    @GetMapping("/checkauto")
    public String checkAutoPage() {
        return "admin-check-auto";
    }

    @PostMapping("/checkauto")
    public String checkAutoPost(@RequestParam String searchParam, Model model) {
        Iterable<Penalty> penalty = penaltyRepository.findAllPenaltyByStateNumber(searchParam);
        model.addAttribute("penalty", penalty);
        model.addAttribute("State_number", searchParam);

        return "admin-check-auto";
    }

    @GetMapping("/checkowner")
    public String checkOwnerPage() {
        return "admin-check-phys";
    }

    @PostMapping("/checkowner")
    public String checkOwnerPost(@RequestParam String searchParam, Model model) {
        Iterable<Penalty> penalty = penaltyRepository.findAllPenaltyByDriverLicense(searchParam);
        model.addAttribute("penalty", penalty);
        model.addAttribute("Driver_license_phys", searchParam);

        return "admin-check-phys";
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
        return "admin-penalty-info";
    }

    @GetMapping("/penalty/{decreeNumber}/edit")
    public String penaltyEdit() {
        return "admin-penalty-edit";
    }
}
