package com.tutorlink.tutor_domain.functional.connectionrequest;

import com.tutorlink.tutor_domain.functional.connectionrequest.model.entity.Connection;
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

    public void processConnectionRequest(Connection connection) {
        log.info("Processing connection request: {}", connection);
        connectionService.processConnection(connection);

        //notify about the connection request
        String notificationMessage = String.format("You have a new connection request from User %d", connection.getStudentId());
        notificationService.notifyConnectionRequest(connection.getTutorId(), notificationMessage);
    }
}

