package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.payment.AcceptPaymentReq;
import com.example.tutorlink.model.dto.request.payment.PaymentReq;
import com.example.tutorlink.model.dto.request.payment.RejectPaymentReq;
import com.example.tutorlink.model.dto.response.payment.PaymentResp;
import com.example.tutorlink.model.dto.response.user.PaymentStatusResp;
import com.example.tutorlink.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Payment Controller", description = "Payment processing endpoints")
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final NotificationService notificationService;

    public PaymentController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Operation(description = "Send payment request", summary = "Send payment request after a tutoring session")
    @PostMapping("/request")
    public ResponseEntity<PaymentResp> sendPaymentRequest(@RequestHeader("Authorization") String studentToken,
                                                          @RequestBody PaymentReq req) {
        // Logic to send payment request
        return ResponseEntity.ok(PaymentResp.builder()
                .paymentRequestId(987L)
                .message("Payment request created. Waiting for student confirmation.")
                .build());
    }

    @Operation(description = "Accept payment request", summary = "Accept payment request after session")
    @PostMapping("/{paymentRequestId}/accept")
    public ResponseEntity<PaymentResp> acceptPayment(@RequestHeader("Authorization") String studentToken,
                                                     @PathVariable Long paymentRequestId,
                                                     @RequestBody AcceptPaymentReq req) {
        // Logic to accept payment
        return ResponseEntity.ok(PaymentResp.builder()
                .transactionId("transaction-uuid")
                .status("Payment accepted and funds transferred.")
                .build());
    }

    @Operation(description = "Reject payment request", summary = "Reject payment request")
    @PostMapping("/{paymentRequestId}/reject")
    public ResponseEntity<PaymentResp> rejectPayment(@RequestHeader("Authorization") String studentToken,
                                                     @PathVariable Long paymentRequestId,
                                                     @RequestBody RejectPaymentReq req) {

        notificationService.notifyStudent(req.getStudentId(), "Your payment request has been rejected.");
        notificationService.notifyTutor(req.getTutorId(), "The payment request for your session has been rejected.");

        return ResponseEntity.ok(PaymentResp.builder()
                .status("Payment request rejected")
                .build());
    }

    @Operation(description = "View payment request status", summary = "Check the status of the payment request")
    @GetMapping("/{paymentRequestId}/status")
    public ResponseEntity<PaymentStatusResp> viewPaymentStatus(@RequestHeader("Authorization") String token,
                                                               @PathVariable Long paymentRequestId) {
        // Logic to fetch payment status
        return ResponseEntity.ok(PaymentStatusResp.builder()
                .paymentRequestId(paymentRequestId)
                .status("Pending")
                .amount(50.0)
                .sessionId(789L)
                .subject("Java")
                .build());
    }
}

