package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller.APIs.API_ConnectionController;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.resp.ConnectionResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@RequiredArgsConstructor
public class ConnectionController implements API_ConnectionController  {

    private final ConnectionService connectionService;

    //create a new connection
    public ResponseEntity<ConnectionResp> createConnection(@RequestBody CreateConnectionReq request) {
        ConnectionResp connection = connectionService.createConnection(request);
        return ResponseEntity.ok(connection);
    }

    //get connections for a specific student
    public ResponseEntity<List<ConnectionResp>> getConnectionsForStudent(@PathVariable Long studentId) {
        List<ConnectionResp> connections = connectionService.getConnectionsForStudent(studentId);
        return ResponseEntity.ok(connections);
    }

    //get connections for a specific tutor
    public ResponseEntity<List<ConnectionResp>> getConnectionsForTutor(@PathVariable Long tutorId) {
        List<ConnectionResp> connections = connectionService.getConnectionsForTutor(tutorId);
        return ResponseEntity.ok(connections);
    }
}

