package com.example.mobileprepaidrechargeservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plan_Model {
    @Id
    private int plan_Id;
    private Double plan_Price;
    private int plan_Validity;
    private String plan_Voice_Calls;
    private String plan_Data;
    private int plan_Sms;
    private String plan_Category;

    public Plan_Model() {
    }

    public Plan_Model(Double plan_Price, int plan_Validity, String plan_VoiceCalls, String plan_Data, int plan_Sms, String plan_Category) {
        this.plan_Price = plan_Price;
        this.plan_Validity = plan_Validity;
        this.plan_Voice_Calls = plan_VoiceCalls;
        this.plan_Data = plan_Data;
        this.plan_Sms = plan_Sms;
        this.plan_Category = plan_Category;
    }

    public int getPlan_Id() {
        return plan_Id;
    }

    public void setPlan_Id(int plan_Id) {
        this.plan_Id = plan_Id;
    }

    public Double getPlan_Price() {
        return plan_Price;
    }

    public void setPlan_Price(Double plan_Price) {
        this.plan_Price = plan_Price;
    }

    public int getPlan_Validity() {
        return plan_Validity;
    }

    public void setPlan_Validity(int plan_Validity) {
        this.plan_Validity = plan_Validity;
    }

    public String getPlan_Voice_Calls() {
        return plan_Voice_Calls;
    }

    public void setPlan_Voice_Calls(String plan_VoiceCalls) {
        this.plan_Voice_Calls = plan_VoiceCalls;
    }

    public String getPlan_Data() {
        return plan_Data;
    }

    public void setPlan_Data(String plan_Data) {
        this.plan_Data = plan_Data;
    }

    public int getPlan_Sms() {
        return plan_Sms;
    }

    public void setPlan_Sms(int plan_Sms) {
        this.plan_Sms = plan_Sms;
    }

    public String getPlan_Category() {
        return plan_Category;
    }

    public void setPlan_Category(String plan_Category) {
        this.plan_Category = plan_Category;
    }

    @Override
    public String toString() {
        return "Plan_Model{" +
                "plan_Id=" + plan_Id +
                ", plan_Price='" + plan_Price + '\'' +
                ", plan_Validity=" + plan_Validity +
                ", plan_VoiceCalls='" + plan_Voice_Calls + '\'' +
                ", plan_Data='" + plan_Data + '\'' +
                ", plan_Sms=" + plan_Sms +
                ", plan_Category='" + plan_Category + '\'' +
                '}';
    }
}
