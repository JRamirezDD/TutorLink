package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.payment.AcceptPaymentReq;
import com.example.tutorlink.model.dto.response.payment.PaymentResp;
import com.example.tutorlink.service.StudentPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Student Payment Controller", description = "Student accepts or rejects payment requests")
@RestController
@RequestMapping("/payments/student")
public class StudentPaymentController {

    private final StudentPaymentService studentPaymentService;

    public StudentPaymentController(StudentPaymentService studentPaymentService) {
        this.studentPaymentService = studentPaymentService;
    }

    @Operation(summary = "Accept payment request", description = "Student accepts the payment request")
    @PostMapping("/{paymentRequestId}/accept")
    public ResponseEntity<PaymentResp> acceptPayment(@PathVariable Long paymentRequestId,
                                                     @RequestBody AcceptPaymentReq req) {
        PaymentResp paymentResp = studentPaymentService.acceptPayment(paymentRequestId);
        return ResponseEntity.ok(paymentResp);
    }

    @Operation(summary = "Reject payment request", description = "Student rejects the payment request")
    @PostMapping("/{paymentRequestId}/reject")
    public ResponseEntity<PaymentResp> rejectPayment(@PathVariable Long paymentRequestId) {
        PaymentResp paymentResp = studentPaymentService.rejectPayment(paymentRequestId);
        return ResponseEntity.ok(paymentResp);
    }
}


