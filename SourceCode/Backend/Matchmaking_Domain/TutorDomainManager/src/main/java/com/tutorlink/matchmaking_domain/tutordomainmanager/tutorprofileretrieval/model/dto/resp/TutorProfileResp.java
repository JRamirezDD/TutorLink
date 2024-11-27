package com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp;

public record TutorProfileResp(
        Long tutorId,
        String name,
        String expertise,
        String location,
        Double rating
) {}

