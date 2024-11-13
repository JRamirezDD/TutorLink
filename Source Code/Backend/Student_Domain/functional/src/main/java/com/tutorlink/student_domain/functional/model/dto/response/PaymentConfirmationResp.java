package com.tutorlink.student_domain.functional.model.dto.response;

public record PaymentConfirmationResp(
        Long paymentRequestId,
        String status, //accepted or rejected
        String message
) {}
