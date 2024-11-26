package com.tutorlink.tutor_domain.functional.profile.model.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTutorProfileReq(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String specialization,
        @NotNull Double hourlyRate,
        String description,
        String location
) {
}


