package com.example.mobileprepaidrechargeservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private int user_Id;
    private String user_Name;
    private String user_Email;
    private long user_Number;

    public UserModel() {

    }

    public UserModel(String user_Name, String user_Email, long user_Number) {
        this.user_Name = user_Name;
        this.user_Email = user_Email;
        this.user_Number = user_Number;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public long getUser_Number() {
        return user_Number;
    }

    public void setUser_Number(long user_Number) {
        this.user_Number = user_Number;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_Id=" + user_Id +
                ", user_Name='" + user_Name + '\'' +
                ", user_Email='" + user_Email + '\'' +
                ", user_Number=" + user_Number +
                '}';
    }
}
