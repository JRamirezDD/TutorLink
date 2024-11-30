package com.tutorlink.tutor_domain.functional.payment.controller;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.tutor_domain.functional.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq req) {
        PaymentResp paymentResponse = paymentService.createPaymentRequest(req);
        return ResponseEntity.ok(paymentResponse);
    }

    @PostMapping("/{paymentId}/pay")
    public ResponseEntity<Void> payRequest(@PathVariable Long paymentId) {
        paymentService.payRequest(paymentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{paymentId}/decline")
    public ResponseEntity<Void> declineRequest(@PathVariable Long paymentId) {
        paymentService.declineRequest(paymentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{paymentRequestId}/accept")
    public ResponseEntity<PaymentConfirmationResp> confirmAcceptPayment(@PathVariable Long paymentRequestId) {
        PaymentConfirmationResp response = paymentService.confirmAcceptPayment(paymentRequestId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{paymentRequestId}/reject")
    public ResponseEntity<PaymentConfirmationResp> confirmRejectPayment(@PathVariable Long paymentRequestId) {
        PaymentConfirmationResp response = paymentService.confirmRejectPayment(paymentRequestId);
        return ResponseEntity.ok(response);
    }
}

