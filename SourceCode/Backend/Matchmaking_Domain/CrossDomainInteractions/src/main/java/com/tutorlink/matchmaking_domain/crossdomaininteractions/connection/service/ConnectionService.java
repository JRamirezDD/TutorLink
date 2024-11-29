package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.ConnectionReqResponseTypes;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.RespondConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.entity.Connection;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.entity.ConnectionStatus;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.publisher.ConnectionPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.repository.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final ConnectionPublisher connectionPublisher;

    public ConnectionResp createConnection(CreateConnectionReq request) {
        //check if a connection already exists
        Optional<Connection> existingConnection = connectionRepository.findByStudentIdAndTutorId(
                request.studentId(), request.tutorId());

        if (existingConnection.isPresent()) {
            throw new RuntimeException("Connection already exists.");
        }

        //create a new connection
        Connection connection = Connection.builder()
                .studentId(request.studentId())
                .tutorId(request.tutorId())
                .status(ConnectionStatus.valueOf("PENDING")) // default status
                .build();

        connectionRepository.save(connection);
        connectionPublisher.publishConnectionEvent(connection);

        return new ConnectionResp(connection.getId(), connection.getStudentId(), connection.getTutorId(), connection.getStatus());
    }

    public List<ConnectionResp> getConnectionsForStudent(Long studentId) {
        return connectionRepository.findByStudentId(studentId).stream()
                .map(conn -> new ConnectionResp(conn.getId(), conn.getStudentId(), conn.getTutorId(), conn.getStatus()))
                .collect(Collectors.toList());
    }

    public List<ConnectionResp> getConnectionsForTutor(Long tutorId) {
        return connectionRepository.findByTutorId(tutorId).stream()
                .map(conn -> new ConnectionResp(conn.getId(), conn.getStudentId(), conn.getTutorId(), conn.getStatus()))
                .collect(Collectors.toList());
    }

    public boolean isConnected(Long userId1, Long userId2) {
        return connectionRepository.findByStudentId(userId1).stream()
                .anyMatch(conn -> conn.getTutorId().equals(userId2) && "ACCEPTED".equals(conn.getStatus()))
                || connectionRepository.findByStudentId(userId2).stream()
                .anyMatch(conn -> conn.getTutorId().equals(userId1) && "ACCEPTED".equals(conn.getStatus()));
    }

    public void validateMessaging(Long senderId, Long receiverId) {
        if (!isConnected(senderId, receiverId)) {
            throw new RuntimeException("Users are not connected. Messaging impossible.");
        }
    }

    public void respondToConnection(RespondConnectionReq connectionRequestResponse) {
        Connection connection = connectionRepository.findById(connectionRequestResponse.connectionId())
                .orElseThrow(() -> new RuntimeException("Connection not found"));

        String status = switch (connectionRequestResponse.responseType()) {
            case ACCEPT -> "ACCEPTED";
            case REJECT -> "REJECTED";
        };

        connection.setStatus(ConnectionStatus.valueOf(status));
        connectionRepository.save(connection); // Save the updated status
    }
}


