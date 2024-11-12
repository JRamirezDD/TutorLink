package com.tutorlink.student_domain.functional.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record SubscriptionReq(
        @NotNull Long studentId,
        @NotBlank String plan,
        @NotNull LocalDateTime expiryDate
) {}


