package com.tutorlink.tutor_domain.auth.model.dto.response;

public record TutorRegistrationResp(
        Long tutorId,
        String username,
        String email,
        String message
) {}

