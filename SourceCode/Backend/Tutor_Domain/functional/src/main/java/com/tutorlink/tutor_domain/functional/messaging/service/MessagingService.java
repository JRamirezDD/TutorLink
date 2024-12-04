package com.tutorlink.tutor_domain.functional.messaging.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import com.tutorlink.tutor_domain.functional.messaging.service.feignclient.Client_CrossDomainInteractions_Messages;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private final Client_CrossDomainInteractions_Messages messagingClient;

    public MessageResp sendMessage(SendMessageReq request) {
        try {
            return messagingClient.sendMessage(request).getBody();
        } catch (Exception e) {
            throw new RuntimeException("Failed to send message", e);
        }
    }

    public List<MessageResp> getMessagesBetweenUsers(Long senderId, Long receiverId) {
        try {
            ResponseEntity<List<MessageResp>> response =
                    messagingClient.getMessagesBetweenUsers(senderId, receiverId);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch messages between users", e);
        }
    }
}
