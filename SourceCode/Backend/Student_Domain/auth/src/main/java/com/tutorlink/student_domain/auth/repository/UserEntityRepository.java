package com.tutorlink.student_domain.auth.repository;

import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
}
