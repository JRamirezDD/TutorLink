package com.example.tutorlink.model.dto.response.subscription;

import java.time.LocalDate;

public class SubscriptionResp {

    private Long studentId;
    private String subscriptionType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;


    public SubscriptionResp() {}

    public SubscriptionResp(Long studentId, String subscriptionType, LocalDate startDate, LocalDate endDate, String status) {
        this.studentId = studentId;
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

