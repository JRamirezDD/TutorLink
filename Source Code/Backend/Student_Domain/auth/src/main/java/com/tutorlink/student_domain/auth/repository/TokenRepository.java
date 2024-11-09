package com.tutorlink.student_domain.auth.repository;

import com.tutorlink.student_domain.auth.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
}

