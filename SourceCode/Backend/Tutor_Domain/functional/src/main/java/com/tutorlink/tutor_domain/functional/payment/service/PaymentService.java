package com.tutorlink.tutor_domain.functional.payment.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.tutor_domain.functional.payment.service.feignclients.Client_CrossDomainInteractions_Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Client_CrossDomainInteractions_Payment paymentClient;

    public PaymentResp createPaymentRequest(PaymentReq req) {
        return paymentClient.createPaymentRequest(req).getBody();
    }

    public void payRequest(Long paymentId) {
        paymentClient.payRequest(paymentId);
    }

    public void declineRequest(Long paymentId) {
        paymentClient.declineRequest(paymentId);
    }

    public PaymentConfirmationResp confirmAcceptPayment(Long paymentRequestId) {
        return paymentClient.confirmAcceptPayment(paymentRequestId);
    }

    public PaymentConfirmationResp confirmRejectPayment(Long paymentRequestId) {
        return paymentClient.confirmRejectPayment(paymentRequestId);
    }
}


