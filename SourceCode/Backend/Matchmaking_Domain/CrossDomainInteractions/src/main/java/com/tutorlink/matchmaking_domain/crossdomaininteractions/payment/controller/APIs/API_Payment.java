package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller.APIs;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface API_Payment {
    @PostMapping
    public ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq request);

    //accept payment request
    @PostMapping("/{paymentId}/accept")
    public ResponseEntity<String> acceptPayment(@PathVariable Long paymentId);

    //reject payment request
    @PostMapping("/{paymentId}/reject")
    public ResponseEntity<String> rejectPayment(@PathVariable Long paymentId);
}
