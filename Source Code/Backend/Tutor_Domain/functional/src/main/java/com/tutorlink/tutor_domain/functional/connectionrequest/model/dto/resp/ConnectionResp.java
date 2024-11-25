package com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.resp;

import lombok.Builder;

@Builder
public record ConnectionResp(
        Long connectionId,
        Long studentId,
        Long tutorId,
        String status
) {}

