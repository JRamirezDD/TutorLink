package com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.controller.APIs;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface API_Messaging {
    @PostMapping
    public ResponseEntity<MessageResp> sendMessage(@RequestBody SendMessageReq request);

    //get all messages between two users
    @GetMapping("/{userId1}/{userId2}")
    public ResponseEntity<List<MessageResp>> getMessagesBetweenUsers(
            @PathVariable Long userId1, @PathVariable Long userId2);
}
