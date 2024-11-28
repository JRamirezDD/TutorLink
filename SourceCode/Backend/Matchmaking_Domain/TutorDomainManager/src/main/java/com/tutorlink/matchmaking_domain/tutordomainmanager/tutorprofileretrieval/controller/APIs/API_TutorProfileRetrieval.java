package com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.controller.APIs;

import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface API_TutorProfileRetrieval {
    @GetMapping("/{tutorId}")
    public ResponseEntity<TutorProfileResp> getTutorProfile(@PathVariable Long tutorId);

    @GetMapping
    public ResponseEntity<List<TutorProfileResp>> getAllTutorProfiles();
}
