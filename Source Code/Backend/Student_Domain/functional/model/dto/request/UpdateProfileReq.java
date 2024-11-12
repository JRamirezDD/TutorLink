package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotBlank;
        //import jakarta.validation.constraints.NotBlank;

public record UpdateProfileReq(
        @NotBlank String username,
        @NotBlank String email
) {}


