package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.notification.NotificationReq;
import com.example.tutorlink.model.dto.response.notification.NotificationResp;
import com.example.tutorlink.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationResp> createNotification(@RequestBody NotificationReq notificationReq) {
        NotificationResp notification = notificationService.createNotification(notificationReq);

        return ResponseEntity.ok(notification);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResp>> getNotificationsByUser(@PathVariable Long userId) {
        List<NotificationResp> notifications = notificationService.getNotificationsByUser(userId);

        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResp> getNotificationById(@PathVariable Long notificationId) {
        NotificationResp notification = notificationService.getNotificationById(notificationId);

        if (notification != null) {
            return ResponseEntity.ok(notification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

