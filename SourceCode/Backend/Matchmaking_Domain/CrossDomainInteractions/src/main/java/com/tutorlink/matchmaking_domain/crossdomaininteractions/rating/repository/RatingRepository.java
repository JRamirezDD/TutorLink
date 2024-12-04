package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByTutorId(Long tutorId);

    @Query("SELECT AVG(CAST(r.ratingValue AS integer)) FROM Rating r WHERE r.tutorId = :tutorId")
Double findAverageByTutorId(Long tutorId);

    }









