package com.tutorlink.tutor_domain.functional.studentViewer.model.dto.resp;

import lombok.Builder;

@Builder
public record StudentProfileResp(
        Long studentId,
        String name,
        String email,
        String subscriptionLevel
) {}

