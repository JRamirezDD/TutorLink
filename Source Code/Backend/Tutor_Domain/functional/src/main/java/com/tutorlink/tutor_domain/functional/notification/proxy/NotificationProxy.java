package com.tutorlink.tutor_domain.functional.notification.proxy;

import com.tutorlink.tutor_domain.functional.email.service.EmailSendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationProxy {

    private final EmailSendingService emailSendingService;

    public void sendNotification(Long userId, String content) {
        //TODO: this
        emailSendingService.sendEmail(userId, content);
    }
}

