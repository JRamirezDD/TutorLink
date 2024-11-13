package com.tutorlink.student_domain.functional.model.dto.request;


import jakarta.validation.constraints.NotNull;

public record EnrollmentReq(
        @NotNull Long studentId
) {}

