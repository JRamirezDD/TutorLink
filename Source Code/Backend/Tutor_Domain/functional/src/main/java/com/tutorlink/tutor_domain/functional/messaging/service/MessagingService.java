package com.tutorlink.tutor_domain.functional.messaging.service;

import com.tutorlink.tutor_domain.functional.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.tutor_domain.functional.messaging.model.dto.resp.MessageResp;
import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import com.tutorlink.tutor_domain.functional.messaging.publisher.MessagePublisher;
import com.tutorlink.tutor_domain.functional.messaging.repository.MessageRepository;
import com.tutorlink.tutor_domain.functional.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private final MessageRepository messageRepository;
    private final NotificationService notificationService;
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

        //trigger notification
        notificationService.notifyMessageReceived(message);

        return new MessageResp(message.getId(), message.getSenderId(), message.getReceiverId(),
                message.getContent(), message.getTimestamp());
    }
}

