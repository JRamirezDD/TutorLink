package com.tutorlink.tutor_domain.functional.connectionrequest.service;



import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.publisher.ConnectionPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.repository.ConnectionRepository;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.req.CreateConnectionReq;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.req.UpdateConnectionStatusReq;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.resp.ConnectionResp;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.entity.Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final ConnectionPublisher connectionPublisher;

    public ConnectionResp createConnection(CreateConnectionReq request) {
        Connection connection = Connection.builder()
                .studentId(request.studentId())
                .tutorId(request.tutorId())
                .status("PENDING")
                .build();

        connectionRepository.save(connection);
        connectionPublisher.publishConnectionEvent(connection);

        return ConnectionResp.builder()
                .connectionId(connection.getId())
                .studentId(connection.getStudentId())
                .tutorId(connection.getTutorId())
                .status(connection.getStatus())
                .build();
    }

    public List<ConnectionResp> getConnectionsForStudent(Long studentId) {
        return connectionRepository.findByStudentId(studentId).stream()
                .map(conn -> ConnectionResp.builder()
                        .connectionId(conn.getId())
                        .studentId(conn.getStudentId())
                        .tutorId(conn.getTutorId())
                        .status(conn.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    public List<ConnectionResp> getConnectionsForTutor(Long tutorId) {
        return connectionRepository.findByTutorId(tutorId).stream()
                .map(conn -> ConnectionResp.builder()
                        .connectionId(conn.getId())
                        .studentId(conn.getStudentId())
                        .tutorId(conn.getTutorId())
                        .status(conn.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    public ConnectionResp updateConnectionStatus(UpdateConnectionStatusReq request) {
        Connection connection = connectionRepository.findById(request.connectionId())
                .orElseThrow(() -> new RuntimeException("Connection not found"));

        connection.setStatus(request.status());
        connectionRepository.save(connection);

        return ConnectionResp.builder()
                .connectionId(connection.getId())
                .studentId(connection.getStudentId())
                .tutorId(connection.getTutorId())
                .status(connection.getStatus())
                .build();
    }

    //process pending connection logic
    public void processConnection(Connection connection) {
        if ("PENDING".equalsIgnoreCase(connection.getStatus())) {
            connection.setStatus("ACCEPTED"); //default to accepted rn
            connectionRepository.save(connection);

            connectionPublisher.publishConnectionEvent(connection);
        }
    }
}

