package com.tutorlink.student_domain.functional.service;


import com.tutorlink.student_domain.functional.model.dto.request.PaymentReq;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentConfirmationResp;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentResp;
import com.tutorlink.student_domain.functional.model.entity.Payment;
import com.tutorlink.student_domain.functional.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository = null;


    //creates new payment request at the end of a tutoring session
    public PaymentResp createPaymentRequest(PaymentReq req) {
        Payment payment = Payment.builder()
                .studentId(req.studentId())
                .amount(req.amount())
                .paymentRequestId(req.paymentRequestId())
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


    @Transactional
    public PaymentConfirmationResp confirmAcceptPayment(Long paymentRequestId) {
        //retrieve payment request from db
        Payment payment = paymentRepository.findById(paymentRequestId)
                .orElseThrow(() -> new RuntimeException("Payment request not found"));

        //ensure the payment is still pending
        if (!"PENDING".equals(payment.getStatus())) {
            throw new RuntimeException("Payment request has already been processed");
        }

        //update payment status to "ACCEPTED"
        payment.setStatus("ACCEPTED");
        paymentRepository.save(payment);

        //return a confirmation response
        return new PaymentConfirmationResp(paymentRequestId, payment.getStatus(), "Payment accepted successfully");
    }

    @Transactional
    public PaymentConfirmationResp confirmRejectPayment(Long paymentRequestId) {
        //retrieve payment request from db
        Payment payment = paymentRepository.findById(paymentRequestId)
                .orElseThrow(() -> new RuntimeException("Payment request not found"));

        //ensure payment is still pending
        if (!"PENDING".equals(payment.getStatus())) {
            throw new RuntimeException("Payment request has already been processed");
        }

        //update payment status to "REJECTED"
        payment.setStatus("REJECTED");
        paymentRepository.save(payment);

        //return confirmation response
        return new PaymentConfirmationResp(paymentRequestId, payment.getStatus(), "Payment rejected successfully");
    }
}

