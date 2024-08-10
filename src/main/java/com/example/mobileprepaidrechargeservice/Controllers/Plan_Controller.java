package com.example.mobileprepaidrechargeservice.Controllers;

import com.example.mobileprepaidrechargeservice.Models.Plan_Model;
import com.example.mobileprepaidrechargeservice.Models.ValidRecharges;
import com.example.mobileprepaidrechargeservice.Repositary.ValidRechargesRepo;
import com.example.mobileprepaidrechargeservice.Services.Plan_Service;
import com.example.mobileprepaidrechargeservice.Services.RechargeSuccessEmail;
import com.example.mobileprepaidrechargeservice.Services.User_Service;
import com.example.mobileprepaidrechargeservice.Services.ValidRechargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/plans")
public class Plan_Controller {

    @Autowired
    private Plan_Service planService;

    @Autowired
    User_Service userService;

    @Autowired
    private ValidRechargesRepo validRecharges;
    @Autowired
    private ValidRechargesService validRechargesService;

    @Autowired
     private RechargeSuccessEmail rechargeSuccessEmail;
    @Autowired
    private User_Service user_Service;

    @GetMapping("/category/{category}")
    public List<Plan_Model> getPlansByCategory(@PathVariable String category) {
        return planService.getPlansByCategory(category);
    }

    @GetMapping("/")
    public List<Plan_Model> getAllPlans() {
        return planService.getAllPlans();
    }
    @GetMapping("/plan/{planId}")
    public Plan_Model getPlanById(@PathVariable int planId) {
        Optional<Plan_Model> plan =planService.getPlanById(planId);
        return plan.orElse(null);
    }

    @PostMapping("/payment/sucess")
    public boolean paymentSucess(@RequestBody Map<String,Object> data) {

        int planId = (int)data.get("planId");
        long mobileNumber = (long)data.get("mobileNumber");

        //getting email of the user
        String user_Email=userService.getEmailByNumber(mobileNumber);
        String email_Subject="SucessFull Recharge from LetsConnect";
        String email_message="Hi Greetings from LetsConnect ,you sucessfully recharged Hope you enjoy the service, Thanks";

        ValidRecharges vr=validRechargesService.addingRecharge(planId,mobileNumber,"upi");
        System.out.println(vr);
         rechargeSuccessEmail.sendSimpleEmail(user_Email,email_Subject,email_message);
         return true;
    }

    @GetMapping("/search/{searchedQuery}")
    public List<Plan_Model>searchedPlans( @PathVariable String  searchedQuery) {

        String searchKeyword = searchedQuery;
        System.out.println(searchKeyword);

        if (searchKeyword.matches(".*[a-zA-Z]+.*")){
            return planService.searchedPlans(searchKeyword,0,0,searchKeyword,searchKeyword);
        }
        else{
            int price, calls=0;
            calls =Integer.parseInt(searchKeyword);
            price=Integer.parseInt(searchKeyword);

            return planService.searchedPlans(searchKeyword,price,calls,searchKeyword,searchKeyword);
        }
    }
    @GetMapping("/userActivePlans")
    public List<ValidRecharges> getUserActivePlans(@RequestParam("userNumber") long userNumber) {
//        long uNum=Long.parseLong(userNumber);
        System.out.println(userNumber);
        return validRechargesService.getActivePlans(userNumber);
    }




}
