package com.tutorlink.tutor_domain.functional.messaging.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import com.tutorlink.tutor_domain.functional.messaging.service.feignclient.Client_CrossDomainInteractions_Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private final Client_CrossDomainInteractions_Messages messagingClient;

    public MessageResp sendMessage(SendMessageReq request) {
        // Delegate the sending of the message to CrossDomainInteractions
        return messagingClient.sendMessage(request).getBody();
    }

    public List<MessageResp> getMessagesBetweenUsers(Long senderId, Long receiverId) {
        // Delegate fetching messages to CrossDomainInteractions
        return (List<MessageResp>) messagingClient.getMessagesBetweenUsers(senderId, receiverId);
    }
}


