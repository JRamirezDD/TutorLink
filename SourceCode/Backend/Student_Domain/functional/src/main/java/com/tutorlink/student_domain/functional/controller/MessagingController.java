package com.tutorlink.student_domain.functional.controller;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req.SendMessageReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp.MessageResp;
import com.tutorlink.student_domain.functional.service.MessagingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessagingController {

    private final MessagingService messagingService;

    @Operation(summary = "Send a message", description = "Allows a user to send a message to another user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message sent successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResp.class),
                            examples = @ExampleObject(value = "{\"messageId\": 501, \"senderId\": 1, \"recipientId\": 2, \"content\": \"hi hello hey\", \"timestamp\": \"2024-11-12T14:30:00\"}")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping("/send")
    public ResponseEntity<MessageResp> sendMessage(@RequestBody SendMessageReq sendMessageReq) {
        MessageResp message = messagingService.sendMessage(sendMessageReq);
        return ResponseEntity.ok(message);
    }

    @Operation(summary = "Get all messages between two users", description = "Retrieves all messages exchanged between two users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of messages between two users",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResp.class),
                            examples = @ExampleObject(value = "[{\"messageId\": 501, \"senderId\": 1, \"recipientId\": 2, \"content\": \"hi hello hey\", \"timestamp\": \"2024-11-12T14:30:00\"}]")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid user IDs")
    })
    @GetMapping("/conversation/{userId}/{otherUserId}")
    public ResponseEntity<List<MessageResp>> getMessagesBetweenUsers(
            @PathVariable Long userId, @PathVariable Long otherUserId) {
        List<MessageResp> messages = messagingService.getMessagesBetweenUsers(userId, otherUserId);
        return ResponseEntity.ok(messages);
    }
}



