package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.repository;



import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.entity.TutorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorServiceRepository extends JpaRepository<TutorService, Long> {

    List<TutorService> findByTutorId(Long tutorId);
}

