package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp;

public record PaymentConfirmationResp(
        Long paymentRequestId,
        String status, // accepted or rejected
        String message
) {}
