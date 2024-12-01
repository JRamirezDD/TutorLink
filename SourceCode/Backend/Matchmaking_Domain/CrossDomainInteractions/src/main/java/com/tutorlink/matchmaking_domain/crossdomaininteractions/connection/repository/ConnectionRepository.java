package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.repository;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    List<Connection> findByStudentId(Long studentId);

    List<Connection> findByTutorId(Long tutorId);

    Optional<Connection> findByStudentIdAndTutorId(Long studentId, Long tutorId); // New method
}

