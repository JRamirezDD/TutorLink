package com.tutorlink.tutor_domain.functional.connectionrequest;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.RespondConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.ConnectionReqResponseTypes;
import com.tutorlink.tutor_domain.functional.connectionrequest.service.ConnectionService;
import com.tutorlink.tutor_domain.functional.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConnectionRequestSubscriber {

    private final ConnectionService connectionService;
    private final NotificationService notificationService;

    public void processConnectionRequest(ConnectionResp connectionResp) {
        log.info("Processing connection request: {}", connectionResp);

        //check connection status and handle it
        if ("PENDING".equalsIgnoreCase(String.valueOf(connectionResp.status()))) {
            RespondConnectionReq responseReq = new RespondConnectionReq(
                    connectionResp.connectionId(),
                    ConnectionReqResponseTypes.ACCEPT
            );

            //respond to the connection request
            connectionService.respondToConnection(responseReq);

            //notify about the connection request processing
            String notificationMessage = String.format(
                    "Connection request to Tutor %d processed. Status: %s",
                    connectionResp.tutorId(),
                    responseReq.responseType()
            );
            notificationService.notifyConnectionRequest(connectionResp.studentId(), notificationMessage);

            log.info("Connection request processed and notification sent.");
        } else {
            log.warn("Connection request is not in 'PENDING' status: {}", connectionResp.status());
        }
    }
}


