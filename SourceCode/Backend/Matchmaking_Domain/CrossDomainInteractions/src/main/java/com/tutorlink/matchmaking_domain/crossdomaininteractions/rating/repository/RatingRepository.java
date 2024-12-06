package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByTutorId(Long tutorId);

    @Query("SELECT AVG(CAST(r.value AS double)) FROM Rating r WHERE r.tutorId = :tutorId")
    Double findAverageByTutorId(Long tutorId);
}
