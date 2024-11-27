package com.example.tutorlink.model.dto.response.notification;


import java.time.LocalDateTime;

public class NotificationResp {

    private Long notificationId;
    private Long userId;
    private String message;
    private String type;
    private LocalDateTime timestamp;

    // Constructors
    public NotificationResp() {}

    public NotificationResp(Long notificationId, Long userId, String message, String type, LocalDateTime timestamp) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

