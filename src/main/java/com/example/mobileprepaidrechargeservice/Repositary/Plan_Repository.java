package com.example.mobileprepaidrechargeservice.Repositary;

import com.example.mobileprepaidrechargeservice.Models.Plan_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Plan_Repository extends JpaRepository<Plan_Model, Integer> {

    // Custom query to find plans by category
    @Query("SELECT p FROM Plan_Model p WHERE p.plan_Category = :category")
    List<Plan_Model> findByCategory(@Param("category") String category);

    @Query("SELECT p FROM Plan_Model p WHERE p.plan_Id = :planId")
    Plan_Model findById(@Param("planId") String planId);


    @Query("select p from Plan_Model p where " +
            "(:searchedPrice is null or p.plan_Price = :searchedPrice) or " +
            "(:searchedCategory is null or p.plan_Category like %:searchedCategory%) or " +
            "(:searchedValidity is null or p.plan_Validity = :searchedValidity) or " +
            "(:searchCalls is null or p.plan_Voice_Calls like %:searchCalls%) or " +
            "(:searchedData is null or p.plan_Data like %:searchedData%)")

            List<Plan_Model> searchedPlan(@Param ("searchedCategory") String category ,@Param("searchedPrice") int price, @Param("searchedValidity") int validity, @Param("searchCalls") String calls, @Param("searchedData") String data);


}
