package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PaymentReq(
        @NotNull Long studentId,
        @NotNull Long paymentRequestId,
        @NotNull BigDecimal amount
) {}


