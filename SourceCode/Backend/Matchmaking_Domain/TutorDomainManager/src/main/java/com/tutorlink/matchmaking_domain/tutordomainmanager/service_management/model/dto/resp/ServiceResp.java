package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.dto.resp;

import lombok.Builder;

@Builder
public record ServiceResp(
        Long id,
        String name,
        String description
) {}

