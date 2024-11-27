package com.tutorlink.student_domain.functional.model.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubscriptionReq(
        @NotNull Long studentId,
        @NotBlank String plan,
        @NotNull LocalDateTime expiryDate
) {
    // Static factory method to create a mock SubscriptionReq object
    public static SubscriptionReq mock() {
        return new SubscriptionReq(
                12345L, // mock studentId
                "mockPlan", // mock plan
                LocalDateTime.now().plusDays(30) // mock expiryDate
        );
    }
}