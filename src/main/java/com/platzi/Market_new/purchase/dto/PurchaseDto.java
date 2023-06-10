package com.platzi.Market_new.purchase.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDto {
    private int purchaseId;
    private String customerId;
    private LocalDateTime date;
    private String mediumPayment;
    private String comment;
    private String state;



    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMediumPayment() {
        return mediumPayment;
    }

    public void setMediumPayment(String mediumPayment) {
        this.mediumPayment = mediumPayment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
}
