package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller.APIs;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.resp.ConnectionResp;
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
}
