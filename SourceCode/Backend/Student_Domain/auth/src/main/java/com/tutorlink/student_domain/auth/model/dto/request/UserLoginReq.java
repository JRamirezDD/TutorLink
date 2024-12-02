package com.tutorlink.student_domain.auth.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserLoginReq(
        @NotNull
        String username,

        @NotBlank
        String password
) {
}

