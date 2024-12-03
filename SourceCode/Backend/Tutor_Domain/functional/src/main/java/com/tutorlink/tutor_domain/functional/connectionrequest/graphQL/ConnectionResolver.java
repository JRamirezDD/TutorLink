package com.tutorlink.tutor_domain.functional.connectionrequest.graphQL;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import com.tutorlink.tutor_domain.functional.connectionrequest.service.ConnectionService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConnectionResolver implements GraphQLQueryResolver {

    private final ConnectionService connectionService;

    public List<ConnectionResp> getAcceptedConnectionsForTutor(Long tutorId) {
        return connectionService.getAcceptedConnectionsForTutor(tutorId);
    }

    public List<ConnectionResp> getPendingConnections(Long tutorId) {
        return connectionService.getPendingConnections(tutorId);
    }
}


