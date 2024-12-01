package com.tutorlink.student_domain.functional.service;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Payment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Client_CrossDomainInteractions_Payment paymentClient;

    //Creates a new payment request
    public PaymentResp createPaymentRequest(PaymentReq req) {
        return paymentClient.createPaymentRequest(req).getBody();
    }

    //Processes the payment
    public void payRequest(Long paymentId) {
        paymentClient.payRequest(paymentId);
    }

    //Declines the payment
    public void declineRequest(Long paymentId) {
        paymentClient.declineRequest(paymentId);
    }

    @Transactional
    public PaymentConfirmationResp confirmAcceptPayment(Long paymentRequestId) {
        return paymentClient.confirmAcceptPayment(paymentRequestId);
    }

    @Transactional
    public PaymentConfirmationResp confirmRejectPayment(Long paymentRequestId) {
        return paymentClient.confirmRejectPayment(paymentRequestId);
    }
}



