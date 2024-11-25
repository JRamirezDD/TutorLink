package com.tutorlink.tutor_domain.functional.email.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSendingService {

    public void sendEmail(Long userId, String content) {
        log.info("Sending email to User {}: {}", userId, content);
        //TODO: not quite sure how this will work with the google API
    }
}

