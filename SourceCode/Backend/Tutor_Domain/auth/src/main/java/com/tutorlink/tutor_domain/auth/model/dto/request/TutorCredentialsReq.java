package com.tutorlink.tutor_domain.auth.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TutorCredentialsReq(
        @NotBlank Long id,
        @NotBlank String username,
        @NotBlank String password
) {}

