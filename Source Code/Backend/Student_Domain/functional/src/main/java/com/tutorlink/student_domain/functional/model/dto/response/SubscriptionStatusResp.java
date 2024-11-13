package com.tutorlink.student_domain.functional.model.dto.response;


import java.time.LocalDateTime;

public record SubscriptionStatusResp(
        String subscriptionPlan,
        LocalDateTime expiryDate
) {}
