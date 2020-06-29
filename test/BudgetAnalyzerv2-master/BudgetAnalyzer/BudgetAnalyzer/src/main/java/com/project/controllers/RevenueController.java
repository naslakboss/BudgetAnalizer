package com.project.controllers;

import com.project.entities.Revenue;
import com.project.repositories.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/revenues", method = {RequestMethod.GET, RequestMethod.POST})
public class RevenueController {

    @Autowired
    RevenueRepository revRepo;

    @GetMapping
    public String displayRevenuesList(Model model, Revenue revenue){

        // Display singular revenue
        Iterable<Revenue> listOfRevenues =revRepo.findAll();
        model.addAttribute("listOfRevenues", listOfRevenues);

        // Display sum of revenues
        int sumOfRevenues = revRepo.sumOfRevenues();
        model.addAttribute("sumOfRevenues", sumOfRevenues);
        return "/revenue/list-revenues";
    }

    @GetMapping("/new")
    public String displayRevenueForm(Model model, Revenue revenue){

        model.addAttribute("revenue", revenue);
        return "/revenue/new-revenue";
    }

    @PostMapping("/save")
    public String addNewRevenue(Model model, Revenue revenue){

        revRepo.save(revenue);
        model.addAttribute("revenue", revenue);
        return "redirect:/revenues";
    }

    @GetMapping("/update")
    public String updateRevenue(@RequestParam("id") long revenueId, Model model, Revenue patchRevenue){
        Revenue aRev = revRepo.findById(revenueId).get();
        model.addAttribute("revenue", aRev);
        if(aRev.getRevenueType() != null){
            aRev.setRevenueType(aRev.getRevenueType());
        }
        if(aRev.getValue() != 0){
            aRev.setValue(aRev.getValue());
        }
        if(aRev.getDate() != null){
            aRev.setDate(aRev.getDate());
        }
        revRepo.save(aRev);
        return "/revenue/new-revenues";
    }

    @DeleteMapping("/delete")
    public String deleteRevenue(@RequestParam("id") long revenueId){
        Revenue delRev = revRepo.findById(revenueId).get();
        revRepo.delete(delRev);
        return "redirect:/revenues";
    }
}
