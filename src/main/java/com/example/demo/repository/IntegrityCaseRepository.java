
 package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

    List<IntegrityCase> findByStatusAndIncidentDateAfter(String status, LocalDate date);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);
} 