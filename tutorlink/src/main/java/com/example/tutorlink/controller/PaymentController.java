package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.payment.PaymentReq;
import com.example.tutorlink.model.dto.response.payment.PaymentResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tutorlink.service.StudentPaymentService;


@Tag(name = "Intermediary Payment Controller", description = "Intermediary controller handling payment requests")
@RestController
@RequestMapping("/payments/intermediary")
public class PaymentController {

    private final StudentPaymentService studentPaymentService;

    public PaymentController(StudentPaymentService studentPaymentService) {
        this.studentPaymentService = studentPaymentService;
    }

    @Operation(summary = "Forward payment request", description = "Intermediary forwards the payment request to the student controller")
    @PostMapping("/forward")
    public ResponseEntity<PaymentResp> forwardPaymentRequest(@RequestBody PaymentReq paymentReq) {
        PaymentResp paymentResp = studentPaymentService.handlePaymentRequest(paymentReq);
        return ResponseEntity.ok(paymentResp);
    }
}

