package com.tutorlink.student_domain.functional.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorlink.student_domain.functional.model.dto.request.PaymentReq;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentConfirmationResp;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentResp;
import com.tutorlink.student_domain.functional.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //create a payment request (end of tutoring session)
    @Operation(summary = "Create a payment request", description = "Generates a payment request at the end of a tutoring session.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment request created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentResp.class),
                            examples = @ExampleObject(value = "{\"paymentId\": 1001, \"amount\": 50.0, \"status\": \"PENDING\", \"requestDate\": \"2024-11-12T10:15:30\"}")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid payment request data")
    })
    @PostMapping("")
    public ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq req) {
        // PaymentResp paymentResponse = paymentService.createPaymentRequest(req);
        PaymentResp paymentResponse = PaymentResp.mock();
        return ResponseEntity.ok(paymentResponse);
    }

    //pay a payment request
    @Operation(summary = "Pay a payment request", description = "Marks a payment request as paid.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment successful",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "\"Payment successful\"")
                    )),
            @ApiResponse(responseCode = "404", description = "Payment request not found"),
            @ApiResponse(responseCode = "400", description = "Invalid payment ID")
    })
    @PostMapping("/{paymentId}/pay")
    public ResponseEntity<String> payRequest(@PathVariable Long paymentId) {
        // paymentService.payRequest(paymentId);
        return ResponseEntity.ok("Payment successful");
    }

    //decline a payment request
    @Operation(summary = "Decline a payment request", description = "Marks a payment request as declined.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment declined",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "\"Payment declined\"")
                    )),
            @ApiResponse(responseCode = "404", description = "Payment request not found"),
            @ApiResponse(responseCode = "400", description = "Invalid payment ID")
    })
    @PostMapping("/{paymentId}/decline")
    public ResponseEntity<String> declineRequest(@PathVariable Long paymentId) {
        // paymentService.declineRequest(paymentId);
        return ResponseEntity.ok("Payment declined");
    }

    //confirm acceptance of payment
    @PostMapping("/{paymentRequestId}/confirm/accept")
    public ResponseEntity<PaymentConfirmationResp> confirmAcceptPayment(@PathVariable Long paymentRequestId) {
        // PaymentConfirmationResp response = paymentService.confirmAcceptPayment(paymentRequestId);
        PaymentConfirmationResp response = PaymentConfirmationResp.mock();
        return ResponseEntity.ok(response);
    }

    //confirm rejection of payment
    @PostMapping("/{paymentRequestId}/confirm/reject")
    public ResponseEntity<PaymentConfirmationResp> confirmRejectPayment(@PathVariable Long paymentRequestId) {
        // PaymentConfirmationResp response = paymentService.confirmRejectPayment(paymentRequestId);
        PaymentConfirmationResp response = PaymentConfirmationResp.mock();
        return ResponseEntity.ok(response);
    }
}


