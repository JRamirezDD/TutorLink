package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.subscription.SubscriptionReq;
import com.example.tutorlink.model.dto.response.subscription.SubscriptionResp;
import com.example.tutorlink.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/{studentId}")
    public ResponseEntity<SubscriptionResp> subscribe(
            @PathVariable Long studentId,
            @RequestBody SubscriptionReq subscriptionRequestDTO) {

        SubscriptionResp subscriptionResponse = subscriptionService.subscribe(studentId, subscriptionRequestDTO);

        return ResponseEntity.ok(subscriptionResponse);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<SubscriptionResp> getSubscriptionStatus(@PathVariable Long studentId) {
        SubscriptionResp subscriptionStatus = subscriptionService.getSubscriptionStatus(studentId);

        return ResponseEntity.ok(subscriptionStatus);
    }
}

