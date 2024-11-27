package com.example.tutorlink.service;

import com.example.tutorlink.model.dto.request.notification.NotificationReq;
import com.example.tutorlink.model.dto.response.notification.NotificationResp;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private List<NotificationResp> notifications = new ArrayList<>();

    public NotificationResp createNotification(NotificationReq notificationReq) {
        NotificationResp notification = new NotificationResp(
                (long) (notifications.size() + 1),
                notificationReq.getUserId(),
                notificationReq.getMessage(),
                notificationReq.getType(),
                LocalDateTime.now()
        );

        notifications.add(notification);

        return notification;
    }

    public List<NotificationResp> getNotificationsByUser(Long userId) {
        return notifications.stream()
                .filter(notification -> notification.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public NotificationResp getNotificationById(Long notificationId) {
        return notifications.stream()
                .filter(notification -> notification.getNotificationId().equals(notificationId))
                .findFirst()
                .orElse(null);
    }
}

