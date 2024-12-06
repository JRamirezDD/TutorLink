package com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp;

import lombok.Builder;

@Builder
public record StudentProfileResp(
        Long studentId,
        String name,
        String email,
        String subscriptionLevel
) {}

