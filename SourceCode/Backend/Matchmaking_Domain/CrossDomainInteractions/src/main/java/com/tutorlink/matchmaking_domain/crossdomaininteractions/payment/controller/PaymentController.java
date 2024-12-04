package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller.APIs.API_Payment;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;


@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController implements API_Payment {

    private final PaymentService paymentService;

    // Create a payment request
    public ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq req) {
        PaymentResp payment = paymentService.createPaymentRequest(req);
        return ResponseEntity.ok(payment);
    }

    // Pay a payment request
    public void payRequest(@PathVariable Long paymentId) {
        paymentService.payRequest(paymentId);
    }

    // Decline a payment request
    public void declineRequest(@PathVariable Long paymentId) {
        paymentService.declineRequest(paymentId);
    }

    // Confirm and accept a payment request
    public PaymentConfirmationResp confirmAcceptPayment(@PathVariable Long paymentRequestId) {
        return paymentService.confirmAcceptPayment(paymentRequestId);
    }

    // Confirm and reject a payment request
    public PaymentConfirmationResp confirmRejectPayment(@PathVariable Long paymentRequestId) {
        return paymentService.confirmRejectPayment(paymentRequestId);
    }

    // New: Get payment details
    public ResponseEntity<PaymentResp> getPayment(@PathVariable Long paymentId) {
        PaymentResp payment = paymentService.getPayment(paymentId);
        return ResponseEntity.ok(payment);
    }
}



