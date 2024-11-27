package com.tutorlink.tutor_domain.auth.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record TutorRegistrationReq(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank @Email String email
) {}

