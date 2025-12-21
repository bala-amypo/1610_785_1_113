package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.RepeatOffenderRecord;
// import com.example.demo.entity.StudentProfile;

@Repository
public interface RepeatOffenderRecordRepository extends JpaRepository<RepeatOffenderRecord, Long> {

    // RepeatOffenderRecord findByStudentProfile(StudentProfile studentProfile);
}