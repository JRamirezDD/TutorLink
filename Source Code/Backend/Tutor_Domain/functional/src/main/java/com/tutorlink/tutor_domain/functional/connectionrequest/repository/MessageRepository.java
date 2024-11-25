package com.tutorlink.tutor_domain.functional.connectionrequest.repository;

import com.tutorlink.tutor_domain.functional.messaging.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    //find messages exchanged between two users
    @Query("SELECT m FROM Message m WHERE " +
            "(m.senderId = :userId1 AND m.receiverId = :userId2) OR " +
            "(m.senderId = :userId2 AND m.receiverId = :userId1) " +
            "ORDER BY m.timestamp ASC")
    List<Message> findMessagesBetweenUsers(Long userId1, Long userId2);

    //find messages sent by a specific user
    List<Message> findBySenderId(Long senderId);

    //find messages received by a specific user
    List<Message> findByReceiverId(Long receiverId);
}

