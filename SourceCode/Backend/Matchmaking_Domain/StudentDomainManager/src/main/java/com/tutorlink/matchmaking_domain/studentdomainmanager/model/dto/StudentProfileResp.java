package com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto;

import lombok.Builder;

@Builder
public record StudentProfileResp(
        Long studentId,
        String name,
        String email,
        String subscriptionLevel
) {}

