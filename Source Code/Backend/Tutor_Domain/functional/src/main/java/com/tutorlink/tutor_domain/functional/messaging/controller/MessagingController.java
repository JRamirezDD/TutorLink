package com.tutorlink.tutor_domain.functional.messaging.controller;


import com.tutorlink.tutor_domain.functional.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.tutor_domain.functional.messaging.model.dto.resp.MessageResp;
import com.tutorlink.tutor_domain.functional.messaging.service.MessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessagingController {

    private final MessagingService messagingService;

    @PostMapping
    public ResponseEntity<MessageResp> sendMessage(@RequestBody SendMessageReq request) {
        MessageResp message = messagingService.sendMessage(request);
        return ResponseEntity.ok(message);
    }
}

