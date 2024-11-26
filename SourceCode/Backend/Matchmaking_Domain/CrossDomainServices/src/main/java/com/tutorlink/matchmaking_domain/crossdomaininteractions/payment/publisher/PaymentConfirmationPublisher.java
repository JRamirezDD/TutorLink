package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.publisher;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentConfirmationPublisher {

    public void publishPaymentConfirmation(Payment payment) {
        log.info("Publishing payment confirmation event: {}", payment);
        //TODO: figure out how this works
    }

    public void publishPaymentRejection(Payment payment) {
        log.info("Publishing payment rejection event: {}", payment);
        //TODO: figure out how this works
    }
}

