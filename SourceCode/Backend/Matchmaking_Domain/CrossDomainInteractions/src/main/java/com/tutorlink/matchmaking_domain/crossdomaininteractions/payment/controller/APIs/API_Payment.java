package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller.APIs;

import com.tutorlink.student_domain.functional.model.dto.response.PaymentConfirmationResp;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentResp;
import org.springframework.web.bind.annotation.*;

public interface API_Payment {

    @PostMapping
    PaymentResp createPaymentRequest(@RequestBody com.tutorlink.student_domain.functional.model.dto.request.PaymentReq req);

    @PostMapping("/{paymentId}/pay")
    void payRequest(@PathVariable Long paymentId);

    @PostMapping("/{paymentId}/decline")
    void declineRequest(@PathVariable Long paymentId);

    @PostMapping("/{paymentRequestId}/accept")
    PaymentConfirmationResp confirmAcceptPayment(@PathVariable Long paymentRequestId);

    @PostMapping("/{paymentRequestId}/reject")
    PaymentConfirmationResp confirmRejectPayment(@PathVariable Long paymentRequestId);
}

