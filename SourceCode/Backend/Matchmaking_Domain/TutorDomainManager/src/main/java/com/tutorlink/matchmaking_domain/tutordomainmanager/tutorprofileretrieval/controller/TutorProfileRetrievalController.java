package com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.controller.APIs.API_TutorProfileRetrieval;
import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.service.TutorProfileRetrievalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tutors")
@RequiredArgsConstructor
public class TutorProfileRetrievalController implements API_TutorProfileRetrieval {

    private final TutorProfileRetrievalService tutorProfileRetrievalService;

    public ResponseEntity<TutorProfileResp> getTutorProfile(@PathVariable Long tutorId) {
        TutorProfileResp profile = tutorProfileRetrievalService.getTutorProfile(tutorId);
        return ResponseEntity.ok(profile);
    }

    public ResponseEntity<List<TutorProfileResp>> getAllTutorProfiles() {
        List<TutorProfileResp> profiles = tutorProfileRetrievalService.getAllTutorProfiles();
        return ResponseEntity.ok(profiles);
    }
}
