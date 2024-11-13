package com.tutorlink.student_domain.functional.repository;


import com.tutorlink.student_domain.functional.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface MessagingRepository extends JpaRepository<Message, Long> {

    // Retrieve messages between two users
    @Query("SELECT m FROM Message m WHERE (m.senderId = :userId AND m.recipientId = :otherUserId) " +
            "OR (m.senderId = :otherUserId AND m.recipientId = :userId) ORDER BY m.timestamp")
    List<Message> findMessagesBetweenUsers(@Param("userId") Long userId, @Param("otherUserId") Long otherUserId);
}


