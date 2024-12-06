package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.publisher;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentRequestPublisher {

    public void publishPaymentRequest(Payment payment) {
        log.info("Publishing payment request event: {}", payment);
        //TODO: figure out how this works
    }
}

