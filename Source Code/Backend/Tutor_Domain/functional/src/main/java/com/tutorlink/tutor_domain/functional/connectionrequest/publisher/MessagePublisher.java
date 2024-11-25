package com.tutorlink.tutor_domain.functional.connectionrequest.publisher;

import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePublisher {

    public void publishMessageEvent(Message message) {
        //TODO: message publishing
        log.info("Publishing message event: {}", message);
    }
}

