package com.example.tutorlink.service;

import com.example.tutorlink.model.dto.response.user.PaymentStatusResp;
import org.springframework.stereotype.Service;

@Service
public class TutorPaymentService {

    // Logic for tutor-side payment management (e.g., checking payment status)

    public PaymentStatusResp checkPaymentStatus(Long paymentRequestId) {
        // Logic to check payment status
        return PaymentStatusResp.builder()
                .status("Pending")
                .paymentRequestId(paymentRequestId)
                .build();
    }
}

