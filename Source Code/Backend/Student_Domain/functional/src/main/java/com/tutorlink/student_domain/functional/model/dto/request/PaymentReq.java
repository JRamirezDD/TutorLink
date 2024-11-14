package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PaymentReq(
        @NotNull Long studentId,
        @NotNull Long paymentRequestId,
        @NotNull BigDecimal amount
) {
    // Static factory method to create a mock PaymentReq object
    public static PaymentReq mock() {
        return new PaymentReq(
                12345L, // mock studentId
                67890L, // mock paymentRequestId
                BigDecimal.valueOf(100.00) // mock amount
        );
    }
}