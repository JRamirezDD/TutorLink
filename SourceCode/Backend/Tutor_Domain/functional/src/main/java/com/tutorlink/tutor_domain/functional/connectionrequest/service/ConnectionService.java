package com.tutorlink.tutor_domain.functional.connectionrequest.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.publisher.ConnectionPublisher;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.repository.ConnectionRepository;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.req.CreateConnectionReq;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.req.UpdateConnectionStatusReq;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.resp.ConnectionResp;
import com.tutorlink.tutor_domain.functional.connectionrequest.model.entity.Connection;
import com.tutorlink.tutor_domain.functional.connectionrequest.service.feignclient.Client_CrossDomainInteractions_Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final ConnectionPublisher connectionPublisher;
    private final Client_CrossDomainInteractions_Connection connectionClient; // Inject Feign Client

    public ConnectionResp createConnection(CreateConnectionReq request) {
        // Delegate to Feign Client
        return connectionClient.createConnection(request);
    }

    public List<ConnectionResp> getConnectionsForStudent(Long studentId) {
        // Delegate to Feign Client
        return connectionClient.getConnectionsForStudent(studentId);
    }

    public List<ConnectionResp> getConnectionsForTutor(Long tutorId) {
        // Delegate to Feign Client
        return connectionClient.getConnectionsForTutor(tutorId);
    }

    public ConnectionResp updateConnectionStatus(UpdateConnectionStatusReq request) {
        // Delegate to Feign Client
        return connectionClient.updateConnectionStatus(request);
    }

    public void processConnection(Connection connection) {
        if ("PENDING".equalsIgnoreCase(connection.getStatus())) {
            connection.setStatus("ACCEPTED"); // Default to accepted for now
            connectionRepository.save(connection);
            connectionPublisher.publishConnectionEvent(connection);

            // Inform remote service of status change (optional)
            UpdateConnectionStatusReq req = new UpdateConnectionStatusReq(
                    connection.getId(),
                    connection.getStatus()
            );
            connectionClient.updateConnectionStatus(req);
        }
    }
}
