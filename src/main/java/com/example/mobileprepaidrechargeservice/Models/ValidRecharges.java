package com.example.mobileprepaidrechargeservice.Models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ValidRecharges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vr_id")
    private Long vrId;

    @Column(name = "vr_user_number", nullable = false)
    private Long vrUserNumber;

    @Column(name = "vr_plan", nullable = false)
    private int vrPlan;

    @Column(name = "vr_plan_price", nullable = false)
    private Double vrPlanPrice;

    @Column(name = "vr_plan_validity", nullable = false)
    private int vrPlanValidity; // in days

    @Column(name = "vr_plan_start", nullable = false)
    private LocalDate vrPlanStart;

    @Column(name = "vr_plan_expire", nullable = false)
    private LocalDate vrPlanExpire;

    @Column(name = "vr_payment_mode", nullable = false)
    private String vrPaymentMode;

    @Column(name = "vr_plan_status", nullable = false)
    private String vrPlanStatus; // Active/Inactive

    @PrePersist
    protected void onCreate() {
        // Set the plan start date to the current date
        this.vrPlanStart = LocalDate.now();
        // Calculate the plan expire date based on validity
        this.vrPlanExpire = vrPlanStart.plusDays(vrPlanValidity);
        // Set the plan status based on current date
        this.vrPlanStatus = LocalDate.now().isBefore(vrPlanExpire) ? "Active" : "Inactive";
    }

    // Getters and Setters

    public Long getVrId() {
        return vrId;
    }

    public void setVrId(Long vrId) {
        this.vrId = vrId;
    }

    public Long getVrUserNumber() {
        return vrUserNumber;
    }

    public void setVrUserNumber(Long vrUserNumber) {
        this.vrUserNumber = vrUserNumber;
    }

    public int getVrPlan() {
        return vrPlan;
    }

    public void setVrPlan(int vrPlan) {
        this.vrPlan = vrPlan;
    }

    public Double getVrPlanPrice() {
        return vrPlanPrice;
    }

    public void setVrPlanPrice(Double vrPlanPrice) {
        this.vrPlanPrice = vrPlanPrice;
    }

    public int getVrPlanValidity() {
        return vrPlanValidity;
    }

    public void setVrPlanValidity(int vrPlanValidity) {
        this.vrPlanValidity = vrPlanValidity;
    }

    public LocalDate getVrPlanStart() {
        return vrPlanStart;
    }

    public void setVrPlanStart(LocalDate vrPlanStart) {
        this.vrPlanStart = vrPlanStart;
    }

    public LocalDate getVrPlanExpire() {
        return vrPlanExpire;
    }

    public void setVrPlanExpire(LocalDate vrPlanExpire) {
        this.vrPlanExpire = vrPlanExpire;
    }

    public String getVrPaymentMode() {
        return vrPaymentMode;
    }

    public void setVrPaymentMode(String vrPaymentMode) {
        this.vrPaymentMode = vrPaymentMode;
    }

    public String getVrPlanStatus() {
        return vrPlanStatus;
    }

    public void setVrPlanStatus(String vrPlanStatus) {
        this.vrPlanStatus = vrPlanStatus;
    }

    @Override
    public String toString() {
        return "ValidRecharges{" +
                "vrId=" + vrId +
                ", vrUserNumber=" + vrUserNumber +
                ", vrPlan='" + vrPlan + '\'' +
                ", vrPlanPrice=" + vrPlanPrice +
                ", vrPlanValidity=" + vrPlanValidity +
                ", vrPlanStart=" + vrPlanStart +
                ", vrPlanExpire=" + vrPlanExpire +
                ", vrPaymentMode='" + vrPaymentMode + '\'' +
                ", vrPlanStatus='" + vrPlanStatus + '\'' +
                '}';
    }
}
