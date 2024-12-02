package com.tutorlink.student_domain.auth.repository;

import java.util.Optional;

import com.tutorlink.student_domain.auth.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findById(Long id);
    public Optional<UserEntity> findByGoogleId(String googleId);
    public Optional<UserEntity> findByEmail(String email);
    public Optional<UserEntity> findByUsername(String username);
}
