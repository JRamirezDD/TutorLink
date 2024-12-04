package com.tutorlink.tutor_domain.functional.notification.service;

import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import com.tutorlink.tutor_domain.functional.notification.proxy.NotificationProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationProxy notificationProxy;

    public void notifyMessageReceived(Message message) {
        String notificationMessage = String.format("New message from User %d: %s", message.getSenderId(),
                message.getContent());
        notificationProxy.sendNotification(message.getReceiverId(), notificationMessage);
    }

    public void notifyConnectionRequest(Long receiverId, String content) {
        notificationProxy.sendNotification(receiverId, content);
    }
}
