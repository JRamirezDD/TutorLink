package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req;

import jakarta.validation.constraints.NotNull;

public record PaymentReq(
        @NotNull Long studentId,
        @NotNull Long tutorId,
        @NotNull Double amount
) {}

