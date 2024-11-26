package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddTutorServiceReq(
        @NotBlank String name,
        String description,
        @NotNull Double hourlyRate
) {}
