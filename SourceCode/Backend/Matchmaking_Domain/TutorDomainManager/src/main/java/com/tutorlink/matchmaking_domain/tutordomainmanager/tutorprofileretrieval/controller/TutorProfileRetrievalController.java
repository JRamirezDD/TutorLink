package com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.controller;

import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.service.TutorProfileRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tutors")
@RequiredArgsConstructor
public class TutorProfileRetrievalController {

    private final TutorProfileRetrievalService tutorProfileRetrievalService;

    @GetMapping("/{tutorId}")
    public ResponseEntity<TutorProfileResp> getTutorProfile(@PathVariable Long tutorId) {
        TutorProfileResp profile = tutorProfileRetrievalService.getTutorProfile(tutorId);
        return ResponseEntity.ok(profile);
    }

    @GetMapping
    public ResponseEntity<List<TutorProfileResp>> getAllTutorProfiles() {
        List<TutorProfileResp> profiles = tutorProfileRetrievalService.getAllTutorProfiles();
        return ResponseEntity.ok(profiles);
    }
}

