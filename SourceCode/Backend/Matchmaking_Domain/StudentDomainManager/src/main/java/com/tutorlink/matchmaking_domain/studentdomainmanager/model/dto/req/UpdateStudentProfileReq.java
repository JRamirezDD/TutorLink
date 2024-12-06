package com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.req;

import lombok.Builder;

@Builder
public record UpdateStudentProfileReq(
        String name,
        String email,
        String subscriptionLevel
) {}

