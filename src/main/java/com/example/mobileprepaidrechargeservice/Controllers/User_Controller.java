package com.example.mobileprepaidrechargeservice.Controllers;

import com.example.mobileprepaidrechargeservice.Models.Plan_Model;
import com.example.mobileprepaidrechargeservice.Models.UserModel;
import com.example.mobileprepaidrechargeservice.Services.User_Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class User_Controller {

    @Autowired
    private User_Service userService;
    static long currentUser;

    @GetMapping("/auth")
    public boolean checkUser(@RequestParam ("mobileNumber")long userNumber, HttpServletRequest request) {
        boolean exists = userService.userExists(userNumber);
        if (exists) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userNumber", userNumber);
            currentUser = userNumber;
        }
        return exists;

    }
    @GetMapping("/currentUser")
    public long getCurrentUserI() {
        return currentUser;
    }

}
