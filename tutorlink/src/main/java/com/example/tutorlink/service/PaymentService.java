package com.example.tutorlink.service;

import com.example.tutorlink.controller.PaymentController;
import com.example.tutorlink.model.dto.request.payment.PaymentReq;
import com.example.tutorlink.model.dto.response.payment.PaymentResp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentController intermediaryPaymentController;

    public PaymentService(PaymentController intermediaryPaymentController) {
        this.intermediaryPaymentController = intermediaryPaymentController;
    }

    // Forward payment request to the intermediary
    public PaymentResp forwardPaymentRequestToIntermediary(PaymentReq paymentReq) {
        // Logic to forward payment request to the intermediary
        return intermediaryPaymentController.forwardPaymentRequest(paymentReq).getBody();
    }
    // Forward payment request to the intermediary controller
    public PaymentResp forwardPaymentRequest(PaymentReq paymentReq) {
        // Forwarding the payment request to the intermediary
        ResponseEntity<PaymentResp> responseEntity = intermediaryPaymentController.forwardPaymentRequest(paymentReq);

        // Process the response received from the intermediary controller
        if (responseEntity != null && responseEntity.getBody() != null) {
            return responseEntity.getBody();
        } else {
            return PaymentResp.builder()
                    .status("Failed to forward payment request")
                    .build();
        }
    }
}
