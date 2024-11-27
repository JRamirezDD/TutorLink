package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //create payment request
    @PostMapping
    public ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq request) {
        PaymentResp payment = paymentService.createPaymentRequest(request);
        return ResponseEntity.ok(payment);
    }

    //accept payment request
    @PostMapping("/{paymentId}/accept")
    public ResponseEntity<String> acceptPayment(@PathVariable Long paymentId) {
        paymentService.acceptPayment(paymentId);
        return ResponseEntity.ok("Payment accepted.");
    }

    //reject payment request
    @PostMapping("/{paymentId}/reject")
    public ResponseEntity<String> rejectPayment(@PathVariable Long paymentId) {
        paymentService.rejectPayment(paymentId);
        return ResponseEntity.ok("Payment rejected.");
    }
}

