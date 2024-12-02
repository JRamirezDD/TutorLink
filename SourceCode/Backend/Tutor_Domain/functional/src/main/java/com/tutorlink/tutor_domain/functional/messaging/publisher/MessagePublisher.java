package com.tutorlink.tutor_domain.functional.messaging.publisher;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import com.tutorlink.tutor_domain.functional.messaging.service.feignclient.Client_CrossDomainInteractions_Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessagePublisher {

    private final Client_CrossDomainInteractions_Messages messagingClient;

    public void publishMessageEvent(Message message) {
        try {
            //map the local message entity to SendMessageReq DTO
            SendMessageReq request = new SendMessageReq(
                    message.getSenderId(),
                    message.getReceiverId(),
                    message.getContent(),
                    message.getTimestamp()
            );

            //use feign client to send the message
            messagingClient.sendMessage(request);

            log.info("Successfully published message event: {}", message);
        } catch (Exception e) {
            log.error("Failed to publish message event for message: {}", message, e);
        }
    }
}

