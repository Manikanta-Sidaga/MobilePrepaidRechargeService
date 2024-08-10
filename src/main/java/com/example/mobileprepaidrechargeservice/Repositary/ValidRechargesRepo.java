package com.example.mobileprepaidrechargeservice.Repositary;

import com.example.mobileprepaidrechargeservice.Models.ValidRecharges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValidRechargesRepo extends JpaRepository<ValidRecharges, Long> {

    @Query("select v from ValidRecharges  v where v.vrUserNumber=:userNumber and v.vrPlanStatus='Active'")
    List<ValidRecharges> getActivePlans(@Param("userNumber") long userNumber);
}
