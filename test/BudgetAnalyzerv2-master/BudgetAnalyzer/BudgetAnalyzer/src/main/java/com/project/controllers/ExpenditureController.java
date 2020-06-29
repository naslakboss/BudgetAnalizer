package com.project.controllers;

import com.project.entities.Expenditure;
import com.project.repositories.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/expenditures", method = {RequestMethod.GET, RequestMethod.POST})
public class ExpenditureController {

    @Autowired
    ExpenditureRepository expRepo;

    @GetMapping
    public String displayExpendituresList(Model model, Expenditure expenditure){
        // List of singular expenditure
        Iterable<Expenditure> listOfExpenditures = expRepo.findAll();
        model.addAttribute("listOfExpenditures", listOfExpenditures);

        // List of monthly expenditures
        int sumOfExpenditures = expRepo.monthlyExpenses();
        model.addAttribute("sumOfExpenditures", sumOfExpenditures);
        return "expenditure/list-expenditures";
    }

    @GetMapping("/new")
    public String displayExpenditureForm(Model model, Expenditure expenditure){

        model.addAttribute("expenditure", expenditure);
        return "expenditure/new-expenditure";
    }

    @PostMapping("/save")
    public String addNewOutcome(Expenditure expenditure, Model model){

        expRepo.save(expenditure);
        model.addAttribute("expenditure", expenditure);
        return "redirect:/expenditures";

    }

    @GetMapping("/update")
    public String updateOutcomeById(@RequestParam("id") long expenditureId, Expenditure patchExp, Model model){
        Expenditure exp = expRepo.findById(expenditureId).get();
        model.addAttribute("expenditure", exp);

        if(patchExp.getExpType() != null){
            exp.setExpType(patchExp.getExpType());
        }

        if(patchExp.getValue() != 0){
            exp.setValue(patchExp.getValue());
        }

        if(patchExp.getDate() != null){
            exp.setDate(patchExp.getDate());
        }
        expRepo.save(exp);
        return "expenditure/new-expenditure";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Long expenditureId){
        Expenditure exp = expRepo.findById(expenditureId).get();
        expRepo.delete(exp);
        return "redirect:/expenditures";
    }
}
