package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.repository;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.entity.TutorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorServiceRepository extends JpaRepository<TutorService, Long> {

    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.tutorId = :tutorId")
    Double findAverageRatingForTutor(Long tutorId);
}


