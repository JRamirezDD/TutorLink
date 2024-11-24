package com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.entity.Message;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.publisher.MessagePublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private final MessageRepository messageRepository;
    private final MessagePublisher messagePublisher;

    public MessageResp sendMessage(SendMessageReq request) {
        Message message = Message.builder()
                .senderId(request.senderId())
                .receiverId(request.receiverId())
                .content(request.content())
                .timestamp(System.currentTimeMillis())
                .build();

        messageRepository.save(message);
        messagePublisher.publishMessageEvent(message);

        return new MessageResp(message.getId(), message.getSenderId(), message.getReceiverId(),
                message.getContent(), message.getTimestamp());
    }

    public List<MessageResp> getMessagesBetweenUsers(Long userId1, Long userId2) {
        return messageRepository.findMessagesBetweenUsers(userId1, userId2).stream()
                .map(message -> new MessageResp(
                        message.getId(),
                        message.getSenderId(),
                        message.getReceiverId(),
                        message.getContent(),
                        message.getTimestamp()))
                .collect(Collectors.toList());
    }
}
