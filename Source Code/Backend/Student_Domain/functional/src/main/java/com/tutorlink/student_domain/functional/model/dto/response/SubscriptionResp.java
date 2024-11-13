package com.tutorlink.student_domain.functional.model.dto.response;


import java.time.LocalDateTime;

public record SubscriptionResp(
        Long studentId,
        String plan,
        LocalDateTime startDate,
        LocalDateTime expiryDate
) {}

