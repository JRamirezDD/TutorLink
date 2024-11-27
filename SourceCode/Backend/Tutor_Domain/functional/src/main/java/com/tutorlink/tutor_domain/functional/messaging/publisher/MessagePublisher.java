package com.tutorlink.tutor_domain.functional.messaging.publisher;

import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePublisher {

    public void publishMessageEvent(Message message) {
        //TODO: messaging
        log.info("Publishing message event: {}", message);
    }
}

