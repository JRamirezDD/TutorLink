package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.controller;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.req.TutorServiceReq;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.resp.TutorServiceResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.service.TutorServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceManagementController {

    private final TutorServiceService tutorServiceService;

    @PostMapping
    public ResponseEntity<TutorServiceResp> createService(@RequestBody TutorServiceReq request) {
        TutorServiceResp response = tutorServiceService.createService(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<TutorServiceResp> getServiceById(@PathVariable Long serviceId) {
        TutorServiceResp response = tutorServiceService.getServiceById(serviceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TutorServiceResp>> getAllServices() {
        List<TutorServiceResp> response = tutorServiceService.getAllServices();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        tutorServiceService.deleteService(serviceId);
        return ResponseEntity.noContent().build();
    }
}

