package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp;

import lombok.Builder;

@Builder
public record PaymentResp(
        Long paymentId,
        Long studentId,
        Long tutorId,
        Double amount,
        String status
) {}

