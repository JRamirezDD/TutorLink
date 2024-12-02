package com.tutorlink.student_domain.auth.repository;
import com.tutorlink.student_domain.auth.model.entity.SessionToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionTokenRepository extends JpaRepository<SessionToken, Long> {
    Optional<SessionToken> findByToken(String token);
    Optional<List<SessionToken>> findByUserId(Long userId);
    void deleteByToken(String token);
    void deleteByUserId(Long userId);
}
