package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller.APIs;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface API_Payment {

    @PostMapping
    ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq req);

    @PostMapping("/{paymentId}/pay")
    void payRequest(@PathVariable Long paymentId);

    @PostMapping("/{paymentId}/decline")
    void declineRequest(@PathVariable Long paymentId);

    @PostMapping("/{paymentRequestId}/accept")
    PaymentConfirmationResp confirmAcceptPayment(@PathVariable Long paymentRequestId);

    @PostMapping("/{paymentRequestId}/reject")
    PaymentConfirmationResp confirmRejectPayment(@PathVariable Long paymentRequestId);
}

