package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.repository;

import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.tutorId = :tutorId")
    Double calculateAverageRating(Long tutorId);
}
