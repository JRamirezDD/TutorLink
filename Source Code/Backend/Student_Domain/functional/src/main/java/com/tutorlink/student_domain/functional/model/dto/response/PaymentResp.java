package com.tutorlink.student_domain.functional.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResp(
        Long paymentId,
        BigDecimal amount,
        String status, // PENDING, PAID, or DECLINED
        LocalDateTime requestDate
) {
    // Static factory method to create a mock PaymentResp object
    public static PaymentResp mock() {
        return new PaymentResp(
                1L, // mock paymentId
                BigDecimal.valueOf(100.00), // mock amount
                "PAID", // mock status
                LocalDateTime.now() // mock requestDate
        );
    }
}