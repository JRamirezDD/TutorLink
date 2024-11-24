package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.req.PaymentReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.dto.resp.PaymentResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.entity.Payment;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.publisher.PaymentConfirmationPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.publisher.PaymentRequestPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentRequestPublisher paymentRequestPublisher;
    private final PaymentConfirmationPublisher paymentConfirmationPublisher;

    public PaymentResp createPaymentRequest(PaymentReq request) {
        Payment payment = Payment.builder()
                .studentId(request.studentId())
                .tutorId(request.tutorId())
                .amount(request.amount())
                .status("PENDING")
                .build();

        paymentRepository.save(payment);
        paymentRequestPublisher.publishPaymentRequest(payment);

        return new PaymentResp(payment.getId(), payment.getStudentId(), payment.getTutorId(),
                payment.getAmount(), payment.getStatus());
    }

    public void acceptPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus("ACCEPTED");
        paymentRepository.save(payment);

        paymentConfirmationPublisher.publishPaymentConfirmation(payment);
    }

    public void rejectPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus("REJECTED");
        paymentRepository.save(payment);

        paymentConfirmationPublisher.publishPaymentRejection(payment);
    }
}

