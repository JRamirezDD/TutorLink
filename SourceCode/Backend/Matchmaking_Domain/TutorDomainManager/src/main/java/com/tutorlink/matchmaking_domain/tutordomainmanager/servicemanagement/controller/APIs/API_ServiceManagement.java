package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.controller.APIs;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.req.TutorServiceReq;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.resp.TutorServiceResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface API_ServiceManagement {

    @PostMapping
    public ResponseEntity<TutorServiceResp> createService(@RequestBody TutorServiceReq request);

    @GetMapping("/{serviceId}")
    public ResponseEntity<TutorServiceResp> getServiceById(@PathVariable Long serviceId);

    @GetMapping
    public ResponseEntity<List<TutorServiceResp>> getAllServices();

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId);
}
