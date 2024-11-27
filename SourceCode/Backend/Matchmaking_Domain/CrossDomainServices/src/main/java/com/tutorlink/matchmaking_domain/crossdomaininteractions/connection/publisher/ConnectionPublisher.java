package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.publisher;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.entity.Connection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConnectionPublisher {

    public void publishConnectionEvent(Connection connection) {
        //simulate publishing an event to a message broker
        log.info("Publishing connection event: {}", connection);
    }
}
