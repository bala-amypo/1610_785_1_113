// package com.example.demo.repository;

// import java.time.LocalDate;
// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.entity.StudentProfile;

// public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

//     List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

//     List<IntegrityCase> findByStudentProfile_StudentId(String studentId);

//     List<IntegrityCase> findByStatusAndIncidentDateAfter(String status, LocalDate date);

//     List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

//     // ✅ Add this for getCasesByStudent(Long id)
//     List<IntegrityCase> findByStudentProfile_Id(Long id);
// }  

package com.example.demo.repository;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {
    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);
    List<IntegrityCase> findByStudentProfile_Id(Long id);
    List<IntegrityCase> findByStudentProfile_StudentId(String studentIdentifier);
    
    // Alias for test 65, 67, 68 compatibility
    default List<IntegrityCase> findByStudentIdentifier(String studentIdentifier) {
        return findByStudentProfile_StudentId(studentIdentifier);
    }

    // For HQL/Query tests
    List<IntegrityCase> findByStatus(String status);
    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);
    
    // Test 66
    default List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate since) {
        return findByStatus(status); // Mock implementation or use @Query
    }
}





package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {
    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);
    List<IntegrityCase> findByStudentProfile_Id(Long studentId);
    List<IntegrityCase> findByStatus(String status);
    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.studentProfile.studentId = :studentId")
    List<IntegrityCase> findByStudentIdentifier(@Param("studentId") String studentId);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.status = :status AND ic.incidentDate >= :date")
    List<IntegrityCase> findRecentCasesByStatus(@Param("status") String status, @Param("date") LocalDate date);
}