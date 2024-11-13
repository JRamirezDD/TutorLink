package com.tutorlink.student_domain.functional.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResp(
        Long paymentId,
        BigDecimal amount,
        String status, // PENDING, PAID, or DECLINED
        LocalDateTime requestDate
) {}

