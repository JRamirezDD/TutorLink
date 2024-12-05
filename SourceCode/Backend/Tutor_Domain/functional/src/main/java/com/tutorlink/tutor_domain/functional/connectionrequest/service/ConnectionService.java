package com.tutorlink.tutor_domain.functional.connectionrequest.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.RespondConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import com.tutorlink.tutor_domain.functional.connectionrequest.service.feignclient.Client_CrossDomainInteractions_Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final Client_CrossDomainInteractions_Connection connectionClient;

    // retrieve all connections for a tutor
    public List<ConnectionResp> getConnectionsForTutor(Long tutorId) {
        return connectionClient.getConnectionsForTutor(tutorId).getBody();
    }

    // respond to a connection request
    public void respondToConnection(RespondConnectionReq respondConnectionReq) {
        connectionClient.getRespondConnection(respondConnectionReq);
    }

    // graphQL: retrieve only accepted connections for a tutor
    public List<ConnectionResp> getAcceptedConnectionsForTutor(Long tutorId) {
        return Objects.requireNonNull(connectionClient.getConnectionsForTutor(tutorId).getBody()).stream()
                .filter(connection -> "ACCEPTED".equalsIgnoreCase(String.valueOf(connection.status())))
                .collect(Collectors.toList());
    }

    public List<ConnectionResp> getPendingConnections(Long tutorId) {
        return getConnectionsForTutor(tutorId).stream()
                .filter(connection -> "PENDING".equalsIgnoreCase(String.valueOf(connection.status())))
                .toList();
    }

}
