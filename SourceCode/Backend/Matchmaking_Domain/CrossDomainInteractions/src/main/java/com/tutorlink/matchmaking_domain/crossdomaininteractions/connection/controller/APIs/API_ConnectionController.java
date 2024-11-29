package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller.APIs;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.RespondConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface API_ConnectionController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ConnectionResp> createConnection(@RequestBody CreateConnectionReq request);

    //get connections for a specific student
    @GetMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ConnectionResp>> getConnectionsForStudent(@PathVariable Long studentId);

    //get connections for a specific tutor
    @GetMapping("/tutors/{tutorId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ConnectionResp>> getConnectionsForTutor(@PathVariable Long tutorId) ;

    //respond to connection
    @PostMapping("/respond")
    @ResponseStatus(HttpStatus.OK)
    public void getRespondConnection(@RequestBody RespondConnectionReq connectionRequestResponse);
}
