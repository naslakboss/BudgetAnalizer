package com.project.controllers;

import com.project.repositories.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.Calendar;


@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    ExpenditureRepository expRepo;

    @GetMapping("/home")
    public String displayOverallBalance(){
//        int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
//
//        int value = expRepo.sumOfMonthExpenditures(currentMonth);

        return "home/home";
    }

}
