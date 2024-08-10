package com.example.mobileprepaidrechargeservice.Services;

import com.example.mobileprepaidrechargeservice.Models.Plan_Model;
import com.example.mobileprepaidrechargeservice.Models.ValidRecharges;
import com.example.mobileprepaidrechargeservice.Repositary.Plan_Repository;
import com.example.mobileprepaidrechargeservice.Repositary.ValidRechargesRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ValidRechargesService  {

    @Autowired
    private ValidRechargesRepo validRechargesRepository;

    @Autowired
    private Plan_Repository planRepository;

    public ValidRecharges createOrUpdateRecharge(ValidRecharges validRecharges) {
        return validRechargesRepository.save(validRecharges);
    }
    public ValidRecharges addingRecharge(int planId,long mobileNumber,String paymentMode){
        Plan_Model plan=planRepository.findById(planId).get();
        LocalDate currentDate = LocalDate.now();
        LocalDate expireDate = LocalDate.now().plusDays(plan.getPlan_Validity());

        ValidRecharges validRecharges = new ValidRecharges();
        validRecharges.setVrUserNumber(mobileNumber);
        validRecharges.setVrPlan(plan.getPlan_Id());
        validRecharges.setVrPlanPrice(plan.getPlan_Price());
        validRecharges.setVrPlanValidity(plan.getPlan_Validity());
        validRecharges.setVrPlanStart(currentDate);
        validRecharges.setVrPlanExpire(expireDate);
        if (expireDate.isBefore(currentDate)) {
            // Expiration date is before the current date
              validRecharges.setVrPlanStatus("Expired");
        } else {
            // Expiration date is not before the current date
            validRecharges.setVrPlanStatus("Active");
        }
        validRecharges.setVrPaymentMode(paymentMode);
        validRechargesRepository.save(validRecharges);
        return validRecharges;
    }
    public List<ValidRecharges> getActivePlans(long userNumber){
        return validRechargesRepository.getActivePlans(userNumber);
    }


}
