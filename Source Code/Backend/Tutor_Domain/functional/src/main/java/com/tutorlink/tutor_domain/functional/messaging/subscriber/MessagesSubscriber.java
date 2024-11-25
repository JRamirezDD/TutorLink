package com.tutorlink.tutor_domain.functional.messaging.subscriber;


import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import com.tutorlink.tutor_domain.functional.messaging.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessagesSubscriber {

    private final MessagingService messagingService;

    public void processMessageEvent(Message message) {
        log.info("Processing received message: {}", message);
    }
}

