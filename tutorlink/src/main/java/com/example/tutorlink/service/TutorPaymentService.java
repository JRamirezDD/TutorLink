package com.example.tutorlink.service;

import com.example.tutorlink.model.dto.response.user.PaymentStatusResp;
import org.springframework.stereotype.Service;

@Service
public class TutorPaymentService {

    public PaymentStatusResp checkPaymentStatus(Long paymentRequestId) {
        return PaymentStatusResp.builder()
                .status("Pending")
                .paymentRequestId(paymentRequestId)
                .build();
    }
}

