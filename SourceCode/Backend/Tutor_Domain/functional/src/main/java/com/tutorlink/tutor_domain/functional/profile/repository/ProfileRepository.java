package com.tutorlink.tutor_domain.functional.profile.repository;

import com.tutorlink.tutor_domain.functional.profile.model.entity.TutorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<TutorProfile, Long> {

    //find tutors by specialization
    List<TutorProfile> findBySpecializationIgnoreCase(String specialization);

    //find tutors in a specific location
    List<TutorProfile> findByLocationIgnoreCase(String location);

    //find tutors within range of hourly rates
    List<TutorProfile> findByHourlyRateBetween(Double minRate, Double maxRate);

    //find tutors by specialization and location
    List<TutorProfile> findBySpecializationIgnoreCaseAndLocationIgnoreCase(String specialization, String location);
}


