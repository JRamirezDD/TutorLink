package com.tutorlink.student_domain.functional.service;

import com.tutorlink.student_domain.functional.model.dto.request.SendMessageReq;
import com.tutorlink.student_domain.functional.model.dto.response.MessageResp;
import com.tutorlink.student_domain.functional.model.entity.Message;
import com.tutorlink.student_domain.functional.repository.MessagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessagingService {

    private final MessagingRepository messagingRepository;

    public MessageResp sendMessage(SendMessageReq req) {
        Message message = Message.builder()
                .senderId(req.senderId())
                .recipientId(req.recipientId())
                .content(req.content())
                .timestamp(LocalDateTime.now())
                .build();

        messagingRepository.save(message);

        return new MessageResp(
                message.getId(),
                message.getSenderId(),
                message.getRecipientId(),
                message.getContent(),
                message.getTimestamp()
        );
    }

    public List<MessageResp> getMessagesBetweenUsers(Long userId, Long otherUserId) {
        return messagingRepository.findMessagesBetweenUsers(userId, otherUserId).stream()
                .map(message -> new MessageResp(
                        message.getId(),
                        message.getSenderId(),
                        message.getRecipientId(),
                        message.getContent(),
                        message.getTimestamp()
                ))
                .collect(Collectors.toList());
    }
}


