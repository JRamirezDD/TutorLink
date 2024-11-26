package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.repository;

import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}

