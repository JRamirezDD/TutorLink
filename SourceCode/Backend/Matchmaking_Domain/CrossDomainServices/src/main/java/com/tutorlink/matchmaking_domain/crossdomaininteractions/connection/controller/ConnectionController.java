package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.resp.ConnectionResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionService connectionService;

    //create a new connection
    @PostMapping
    public ResponseEntity<ConnectionResp> createConnection(@RequestBody CreateConnectionReq request) {
        ConnectionResp connection = connectionService.createConnection(request);
        return ResponseEntity.ok(connection);
    }

    //get connections for a specific student
    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<ConnectionResp>> getConnectionsForStudent(@PathVariable Long studentId) {
        List<ConnectionResp> connections = connectionService.getConnectionsForStudent(studentId);
        return ResponseEntity.ok(connections);
    }

    //get connections for a specific tutor
    @GetMapping("/tutors/{tutorId}")
    public ResponseEntity<List<ConnectionResp>> getConnectionsForTutor(@PathVariable Long tutorId) {
        List<ConnectionResp> connections = connectionService.getConnectionsForTutor(tutorId);
        return ResponseEntity.ok(connections);
    }
}

