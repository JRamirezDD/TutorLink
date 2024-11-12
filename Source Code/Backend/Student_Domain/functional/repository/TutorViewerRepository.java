package com.tutorlink.student_domain.functional.repository;


import com.tutorlink.student_domain.functional.model.dto.response.TutorProfileResp;
import com.tutorlink.student_domain.functional.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TutorViewerRepository extends JpaRepository<Tutor, Long> {

    @Query("SELECT COUNT(tv) FROM TutorView tv WHERE tv.studentId = :studentId AND tv.dateViewed = :date")
    long countDailyViews(@Param("studentId") Long studentId, @Param("date") LocalDate date);

    @Query("SELECT new com.tutorlink.student_domain.tutor.model.dto.response.TutorProfileResp(t.id, t.name, t.expertise, t.rating, t.hourlyRate) FROM Tutor t")
    List<TutorProfileResp> findAllTutors();

    @Query("SELECT new com.tutorlink.student_domain.tutor.model.dto.response.TutorProfileResp(t.id, t.name, t.expertise, t.rating, t.hourlyRate) FROM Tutor t WHERE t.id = :tutorId")
    TutorProfileResp findTutorProfileById(@Param("tutorId") Long tutorId);

    @Modifying
    @Query("INSERT INTO TutorView (studentId, tutorId, dateViewed) VALUES (:studentId, :tutorId, :date)")
    void incrementDailyViewCount(@Param("studentId") Long studentId, @Param("tutorId") Long tutorId, @Param("date") LocalDate date);
}
