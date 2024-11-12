package com.tutorlink.student_domain.functional.service;


import com.tutorlink.student_domain.functional.model.dto.request.PaymentReq;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentResp;
import com.tutorlink.student_domain.functional.model.entity.Payment;
import com.tutorlink.student_domain.functional.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;


    //creates new payment request at the end of a tutoring session
    public PaymentResp createPaymentRequest(PaymentReq req) {
        Payment payment = Payment.builder()
                .studentId(req.studentId())
                .amount(req.amount())
                .sessionId(req.sessionId())
                .status("PENDING")
                .requestDate(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);

        return new PaymentResp(payment.getId(), payment.getAmount(), payment.getStatus(), payment.getRequestDate());
    }


     //processes the payment for payment request.
    public void payRequest(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment request not found"));

        payment.setStatus("PAID");
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);
    }


    //ddeclines the payment for a given payment request
    public void declineRequest(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment request not found"));

        payment.setStatus("DECLINED");
        paymentRepository.save(payment);
    }
}

