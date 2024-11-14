package com.tutorlink.student_domain.functional.controller;


import com.tutorlink.student_domain.functional.model.dto.response.SubscriptionResp;
import com.tutorlink.student_domain.functional.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    //upgrade to gold subscription
    @Operation(summary = "Upgrade to Gold subscription", description = "Upgrades the student’s subscription to Gold.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription upgraded successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionResp.class),
                            examples = @ExampleObject(value = "{\"studentId\": 3, \"plan\": \"Gold\", \"startDate\": \"2024-01-01T00:00:00\", \"expiryDate\": \"2025-01-01T00:00:00\"}")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping("/{studentId}/upgrade")
    public ResponseEntity<SubscriptionResp> upgradeToGold(@PathVariable Long studentId) {
        // SubscriptionResp subscription = subscriptionService.upgradeToGold(studentId);
        SubscriptionResp subscription = SubscriptionResp.mock();
        return ResponseEntity.ok(subscription);
    }

    //view student subscription status
    @Operation(summary = "View a student's subscription status", description = "Retrieves the subscription status of the specified student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription status retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionResp.class),
                            examples = @ExampleObject(value = "{\"studentId\": 3, \"plan\": \"Gold\", \"startDate\": \"2024-01-01T00:00:00\", \"expiryDate\": \"2025-01-01T00:00:00\"}")
                    )),
            @ApiResponse(responseCode = "404", description = "Subscription not found"),
            @ApiResponse(responseCode = "400", description = "Invalid student ID")
    })
    @GetMapping("/{studentId}")
    public ResponseEntity<SubscriptionResp> getSubscription(@PathVariable Long studentId) {
        // SubscriptionResp subscription = subscriptionService.getSubscription(studentId);
        SubscriptionResp subscription = SubscriptionResp.mock();
        return ResponseEntity.ok(subscription);
    }
}



