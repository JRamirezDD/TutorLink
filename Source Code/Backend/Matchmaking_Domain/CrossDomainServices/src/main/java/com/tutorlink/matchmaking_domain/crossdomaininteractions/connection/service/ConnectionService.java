package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.resp.ConnectionResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.entity.Connection;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.publisher.ConnectionPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.repository.ConnectionRepository;
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
                .status("PENDING") //default status
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

}

