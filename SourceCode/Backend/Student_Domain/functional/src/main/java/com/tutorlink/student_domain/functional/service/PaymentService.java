package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Payment;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Client_CrossDomainInteractions_Payment paymentClient;

    public PaymentResp createPaymentRequest(PaymentReq req) {
        ResponseEntity<PaymentResp> response = paymentClient.createPaymentRequest(req);
        return response.getBody();
    }

    // Processes the payment
    public void payRequest(Long paymentId) {
        paymentClient.payRequest(paymentId);
    }

    // Declines the payment
    public void declineRequest(Long paymentId) {
        paymentClient.declineRequest(paymentId);
    }

    // Confirms acceptance of a payment
    public PaymentConfirmationResp confirmAcceptPayment(Long paymentRequestId) {
        return paymentClient.confirmAcceptPayment(paymentRequestId);
    }

    // Confirms rejection of a payment
    public PaymentConfirmationResp confirmRejectPayment(Long paymentRequestId) {
        return paymentClient.confirmRejectPayment(paymentRequestId);
    }

    // Retrieves payment details by ID
    public PaymentResp getPayment(Long paymentId) {
        ResponseEntity<PaymentResp> response = paymentClient.getPayment(paymentId);
        return response.getBody();
    }
}
