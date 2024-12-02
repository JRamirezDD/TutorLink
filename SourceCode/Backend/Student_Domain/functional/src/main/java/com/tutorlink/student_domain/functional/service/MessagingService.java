package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Messaging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private final Client_CrossDomainInteractions_Messaging messagingClient;

    public MessageResp sendMessage(SendMessageReq req) {
        // Delegate the sending of the message to the CrossDomainInteractions API
        return messagingClient.sendMessage(req).getBody();
    }

    public List<MessageResp> getMessagesBetweenUsers(Long userId, Long otherUserId) {
        // Delegate the retrieval of messages to the CrossDomainInteractions API
        return (List<MessageResp>) messagingClient.getMessagesBetweenUsers(userId, otherUserId);
    }
}
