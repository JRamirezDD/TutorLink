package com.tutorlink.tutor_domain.functional.ratingviewer.repository;

import com.tutorlink.tutor_domain.functional.ratingviewer.model.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByTutorId(Long tutorId);

    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.tutorId = :tutorId")
    Double calculateAverageRating(Long tutorId);
}

