//  package com.example.demo.repository;

// import com.example.demo.entity.AppUser;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface AppUserRepository extends JpaRepository<AppUser, Long> {
//     Optional<AppUser> findByUsername(String username);
//      Optional<AppUser> findByEmail(String email);
     
//     boolean existsByEmail(String email); 
// }





package com.example.demo.repository;

import com.example.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    boolean existsByEmail(String email);
}








package com.example.demo.repository;

import com.example.demo.entity.EvidenceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord, Long> {
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



package com.example.demo.repository;

import com.example.demo.entity.PenaltyAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenaltyActionRepository extends JpaRepository<PenaltyAction, Long> {
}



package com.example.demo.repository;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepeatOffenderRecordRepository extends JpaRepository<RepeatOffenderRecord, Long> {
    Optional<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
}




package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}



package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}