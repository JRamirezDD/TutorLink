package com.tutorlink.student_domain.functional.model.dto.response;

public record PaymentConfirmationResp(
        Long paymentRequestId,
        String status, // accepted or rejected
        String message
) {
    // Static factory method to create a mock PaymentConfirmationResp object
    public static PaymentConfirmationResp mock() {
        return new PaymentConfirmationResp(
                1L, // mock paymentRequestId
                "accepted", // mock status
                "Payment has been accepted." // mock message
        );
    }
}