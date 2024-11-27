package com.tutorlink.student_domain.functional.model.dto.response;

import java.time.LocalDateTime;

public record SubscriptionStatusResp(
        String subscriptionPlan,
        LocalDateTime expiryDate
) {
    // Static factory method to create a mock SubscriptionStatusResp object
    public static SubscriptionStatusResp mock() {
        return new SubscriptionStatusResp(
                "mockPlan", // mock subscriptionPlan
                LocalDateTime.now().plusDays(30) // mock expiryDate
        );
    }
}