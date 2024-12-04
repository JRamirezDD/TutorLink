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
    ResponseEntity<MessageResp> sendMessage(@RequestBody SendMessageReq request);

    @GetMapping("/{senderId}/{receiverId}")
    ResponseEntity<List<MessageResp>> getMessagesBetweenUsers(
            @PathVariable("senderId") Long senderId,
            @PathVariable("receiverId") Long receiverId);
}
