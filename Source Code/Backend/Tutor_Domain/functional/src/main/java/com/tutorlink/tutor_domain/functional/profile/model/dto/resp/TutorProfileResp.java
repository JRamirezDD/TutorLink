package com.tutorlink.tutor_domain.functional.profile.model.dto.resp;

import lombok.Builder;

@Builder
public record TutorProfileResp(
        Long tutorId,
        String name,
        String email,
        String specialization,
        Double hourlyRate,
        String description,
        String location
) {
}


