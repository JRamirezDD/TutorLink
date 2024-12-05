package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentConfirmationResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.entity.Payment;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.publisher.PaymentConfirmationPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.publisher.PaymentRequestPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentRequestPublisher paymentRequestPublisher;
    private final PaymentConfirmationPublisher paymentConfirmationPublisher;

    // Create a new payment request
    public PaymentResp createPaymentRequest(PaymentReq request) {
        Payment payment = Payment.builder()
                .studentId(request.studentId())
                .tutorId(request.tutorId())
                .amount(request.amount())
                .status("PENDING")
                .requestDate(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);
        paymentRequestPublisher.publishPaymentRequest(payment);

        return mapToPaymentResp(payment);
    }

    // Process the payment
    public void payRequest(Long paymentId) {
        Payment payment = findPaymentById(paymentId);

        if (!"PENDING".equals(payment.getStatus())) {
            throw new RuntimeException("Payment request already processed");
        }

        payment.setStatus("PAID");
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        paymentConfirmationPublisher.publishPaymentConfirmation(payment);
    }

    // Decline the payment
    public void declineRequest(Long paymentId) {
        Payment payment = findPaymentById(paymentId);

        if (!"PENDING".equals(payment.getStatus())) {
            throw new RuntimeException("Payment request already processed");
        }

        payment.setStatus("DECLINED");
        paymentRepository.save(payment);

        paymentConfirmationPublisher.publishPaymentRejection(payment);
    }

    // Confirm and accept a payment request
    public PaymentConfirmationResp confirmAcceptPayment(Long paymentRequestId) {
        Payment payment = findPaymentById(paymentRequestId);

        if (!"PENDING".equals(payment.getStatus())) {
            throw new RuntimeException("Payment request already processed");
        }

        payment.setStatus("ACCEPTED");
        paymentRepository.save(payment);

        paymentConfirmationPublisher.publishPaymentConfirmation(payment);

        return new PaymentConfirmationResp(paymentRequestId, "ACCEPTED", "Payment accepted successfully.");
    }

    // Confirm and reject a payment request
    public PaymentConfirmationResp confirmRejectPayment(Long paymentRequestId) {
        Payment payment = findPaymentById(paymentRequestId);

        if (!"PENDING".equals(payment.getStatus())) {
            throw new RuntimeException("Payment request already processed");
        }

        payment.setStatus("REJECTED");
        paymentRepository.save(payment);

        paymentConfirmationPublisher.publishPaymentRejection(payment);

        return new PaymentConfirmationResp(paymentRequestId, "REJECTED", "Payment rejected successfully.");
    }

    //Get payment details
    public PaymentResp getPayment(Long paymentId) {
        Payment payment = findPaymentById(paymentId);
        return mapToPaymentResp(payment);
    }

    //Utility method to fetch a payment by ID
    private Payment findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
    }

    //Utility method to map Payment entity to PaymentResp DTO
    private PaymentResp mapToPaymentResp(Payment payment) {
        return PaymentResp.builder()
                .paymentId(payment.getId())
                .studentId(payment.getStudentId())
                .tutorId(payment.getTutorId())
                .amount(payment.getAmount())
                .status(payment.getStatus())
                .build();
    }
}



