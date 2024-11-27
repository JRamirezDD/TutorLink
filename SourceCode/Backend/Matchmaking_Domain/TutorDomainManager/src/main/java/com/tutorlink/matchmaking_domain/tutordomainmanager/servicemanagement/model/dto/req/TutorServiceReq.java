package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TutorServiceReq(
        @NotNull Long tutorId,
        @NotBlank String serviceName,
        @NotNull Double hourlyRate,
        String description
) {}

