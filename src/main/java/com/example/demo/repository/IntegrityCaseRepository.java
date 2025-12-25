// package com.example.demo.repository;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.entity.StudentProfile;

// public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

//     // Find all cases for a given StudentProfile
//     List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

//     // ✅ Corrected: find by studentId through the relation
//     List<IntegrityCase> findByStudentProfile_StudentId(String studentId);

//     // Example: find recent cases by status and after a certain date
//     List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate date);

//     // Find cases between dates
//     List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

// }


package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

    List<IntegrityCase> findByStudentProfile_StudentId(String studentId);

    // Fixed method
    List<IntegrityCase> findByStatusAndIncidentDateAfter(String status, LocalDate date);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

    
}
