package com.tutorlink.student_domain.functional.model.dto.response;

import java.time.LocalDateTime;

public record SubscriptionResp(
        Long studentId,
        String plan,
        LocalDateTime startDate,
        LocalDateTime expiryDate
) {
    // Static factory method to create a mock SubscriptionResp object
    public static SubscriptionResp mock() {
        return new SubscriptionResp(
                12345L, // mock studentId
                "mockPlan", // mock plan
                LocalDateTime.now().minusDays(30), // mock startDate
                LocalDateTime.now().plusDays(30) // mock expiryDate
        );
    }
}