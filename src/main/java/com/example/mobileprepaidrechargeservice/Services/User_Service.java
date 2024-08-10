package com.example.mobileprepaidrechargeservice.Services;

import com.example.mobileprepaidrechargeservice.Models.UserModel;
import com.example.mobileprepaidrechargeservice.Repositary.User_Repository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class User_Service {

    @Autowired
    private User_Repository userRepository;
    HttpSession session;

    // Method to find a user by their number using the custom query
    public boolean userExists(long userNumber) {
        Optional<UserModel> user = userRepository.getByUserNumber(userNumber);
        return user.isPresent();
    }

    // Method to retrieve all users
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public String getEmailByNumber(long mobileNumber) {
      UserModel user=  userRepository.getByUserNumber(mobileNumber).orElse(null);
      return user.getUser_Email();
    }


}
