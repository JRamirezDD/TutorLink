package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.ratingValue) FROM Rating r WHERE r.tutorId = :tutorId")
    Double findAverageByTutorId(Long tutorId);

        //custom method to find all ratings by tutorId
        List<Rating> findByTutorId(Long tutorId);
    }









