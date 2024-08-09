package com.example.mobileprepaidrechargeservice;

import com.example.mobileprepaidrechargeservice.Services.User_Service;
import com.example.mobileprepaidrechargeservice.Services.ValidRechargesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobilePrepaidRechargeServiceApplication implements CommandLineRunner {
    @Autowired
    ValidRechargesService validRechargesService;

    @Autowired
    User_Service userService;

    HttpSession session;

    public static void main(String[] args)  {
        SpringApplication.run(MobilePrepaidRechargeServiceApplication.class, args);



    }

    @Override
    public void run(String... args) throws Exception {
        //validRechargesService.getActivePlans();

    }
}
