package com.tutorlink.student_domain.functional.repository;

import com.tutorlink.student_domain.functional.model.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByStudentId(Long studentId);
}

