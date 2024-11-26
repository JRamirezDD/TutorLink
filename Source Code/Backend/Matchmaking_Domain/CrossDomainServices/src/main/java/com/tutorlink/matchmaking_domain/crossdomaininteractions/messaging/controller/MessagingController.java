package com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.controller;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.service.MessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessagingController {

    private final MessagingService messagingService;

    //send a message
    @PostMapping
    public ResponseEntity<MessageResp> sendMessage(@RequestBody SendMessageReq request) {
        MessageResp message = messagingService.sendMessage(request);
        return ResponseEntity.ok(message);
    }

    //get all messages between two users
    @GetMapping("/{userId1}/{userId2}")
    public ResponseEntity<List<MessageResp>> getMessagesBetweenUsers(
            @PathVariable Long userId1, @PathVariable Long userId2) {
        List<MessageResp> messages = messagingService.getMessagesBetweenUsers(userId1, userId2);
        return ResponseEntity.ok(messages);
    }
}
