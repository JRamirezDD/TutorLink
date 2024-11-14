package com.tutorlink.student_domain.functional.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record PaymentReq(
        @NotNull Long studentId,
        @NotNull Long sessionId,
        @NotNull BigDecimal amount
) {
    // Static factory method to create a mock PaymentReq object
    public static PaymentReq mock() {
        return new PaymentReq(
                12345L, // mock studentId
                67890L, // mock sessionId
                BigDecimal.valueOf(100.00) // mock amount
        );
    }
}
