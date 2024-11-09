package com.tutorlink.student_domain.auth.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCredentialsReq(
        @NotNull
        Long userId,

        @NotBlank
        String password
) {
}

