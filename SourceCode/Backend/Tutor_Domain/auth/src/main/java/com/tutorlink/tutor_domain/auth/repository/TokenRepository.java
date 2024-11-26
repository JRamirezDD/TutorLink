package com.tutorlink.tutor_domain.auth.repository;

import com.tutorlink.tutor_domain.auth.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
}

