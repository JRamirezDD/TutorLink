package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateStudentProfileReq(
        @NotBlank String name,
        @NotBlank @Email String email
) {}
