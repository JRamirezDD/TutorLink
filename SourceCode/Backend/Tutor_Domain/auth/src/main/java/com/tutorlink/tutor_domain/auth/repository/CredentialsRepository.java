package com.tutorlink.tutor_domain.auth.repository;

import com.tutorlink.tutor_domain.auth.model.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository extends JpaRepository<TutorEntity, Long> {
    Optional<TutorEntity> findByUsername(String username);
}


