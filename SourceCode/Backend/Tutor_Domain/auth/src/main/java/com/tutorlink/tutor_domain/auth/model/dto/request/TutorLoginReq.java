package com.tutorlink.tutor_domain.auth.model.dto.request;


import jakarta.validation.constraints.NotBlank;

public record TutorLoginReq(
        @NotBlank String username,
        @NotBlank String password
) {}

