package com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.publisher;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePublisher {

    public void publishMessageEvent(Message message) {
        //simulate event publishing (message broker)
        log.info("Publishing message event: {}", message);
    }
}

