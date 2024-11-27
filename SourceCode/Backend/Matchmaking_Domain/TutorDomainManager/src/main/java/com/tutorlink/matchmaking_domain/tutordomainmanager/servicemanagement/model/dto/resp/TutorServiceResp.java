package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.resp;

public record TutorServiceResp(
        Long serviceId,
        Long tutorId,
        String serviceName,
        Double hourlyRate,
        String description,
        Double averageRating
) {}

