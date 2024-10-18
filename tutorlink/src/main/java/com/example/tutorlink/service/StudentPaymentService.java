package com.example.tutorlink.service;

import com.example.tutorlink.model.dto.request.payment.PaymentReq;
import com.example.tutorlink.model.dto.response.payment.PaymentResp;
import org.springframework.stereotype.Service;

@Service
public class StudentPaymentService {

    // Logic for student-side payment request handling (e.g., accept or reject)
    public PaymentResp acceptPayment(Long paymentRequestId) {
        // Logic to accept the payment
        return PaymentResp.builder()
                .status("Payment accepted by student")
                .build();
    }

    public PaymentResp rejectPayment(Long paymentRequestId) {
        // Logic to reject the payment
        return PaymentResp.builder()
                .status("Payment rejected by student")
                .build();
    }

    // Handle payment request forwarded from intermediary
    public PaymentResp handlePaymentRequest(PaymentReq paymentReq) {
        // Logic for handling the payment request, for example, displaying the request to the student
        return PaymentResp.builder()
                .status("Payment request received for session: " + paymentReq.getSessionId())
                .build();
    }
}


