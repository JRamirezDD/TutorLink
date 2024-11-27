package com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.service;

import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.proxy.TutorDomainProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorProfileRetrievalService {

    private final TutorDomainProxy tutorDomainProxy;

    public TutorProfileResp getTutorProfile(Long tutorId) {
        return tutorDomainProxy.fetchTutorProfile(tutorId);
    }

    public List<TutorProfileResp> getAllTutorProfiles() {
        return tutorDomainProxy.fetchAllTutorProfiles();
    }
}

