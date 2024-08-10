package com.example.mobileprepaidrechargeservice.Services;

import com.example.mobileprepaidrechargeservice.Models.Plan_Model;
import com.example.mobileprepaidrechargeservice.Repositary.Plan_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Plan_Service {

    @Autowired
    private Plan_Repository planRepository;

    // Method to find plans by category
    public List<Plan_Model> getPlansByCategory(String category) {
        return planRepository.findByCategory(category);
    }

    // Method to retrieve all plans
    public List<Plan_Model> getAllPlans() {
        return planRepository.findAll();
    }
    public Optional<Plan_Model> getPlanById(int planId) {
        return Optional.ofNullable(planRepository.findById(planId).orElse(null));
    }
    public List<Plan_Model> searchedPlans(String category, int price, int validity, String calls , String data){
        return planRepository.searchedPlan(category,price,validity,calls,data);
    }
}