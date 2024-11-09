package com.tutorlink.student_domain.auth.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserReq(
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        String email
) {
}
