package com.example.tutorlink.model.dto.request.subscription;


public class SubscriptionReq {

    private String subscriptionType;
    private String paymentMethod;
    private int durationMonths;

    public SubscriptionReq() {}

    public SubscriptionReq(String subscriptionType, String paymentMethod, int durationMonths) {
        this.subscriptionType = subscriptionType;
        this.paymentMethod = paymentMethod;
        this.durationMonths = durationMonths;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }
}

