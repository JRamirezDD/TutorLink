package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.payment.PaymentReq;
import com.example.tutorlink.model.dto.response.payment.PaymentResp;
import com.example.tutorlink.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tutor Payment Controller", description = "Tutor sends payment requests")
@RestController
@RequestMapping("/payments/tutor")
public class TutorPaymentController {

    private final PaymentService paymentService;

    public TutorPaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Send payment request", description = "Tutor sends a payment request to the intermediary controller")
    @PostMapping("/request")
    public ResponseEntity<PaymentResp> sendPaymentRequest(@RequestBody PaymentReq paymentReq) {
        PaymentResp paymentResp = paymentService.forwardPaymentRequest(paymentReq);
        return ResponseEntity.ok(paymentResp);
    }
}


