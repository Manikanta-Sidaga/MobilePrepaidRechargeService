package com.example.mobileprepaidrechargeservice.Repositary;

import com.example.mobileprepaidrechargeservice.Models.Plan_Model;
import com.example.mobileprepaidrechargeservice.Models.UserModel;
import com.example.mobileprepaidrechargeservice.Models.ValidRecharges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<UserModel, Integer> {
    // Custom query to find a user by their number
    @Query("SELECT u FROM UserModel u WHERE u.user_Number = :userNumber")
    Optional<UserModel> getByUserNumber(long userNumber);







}