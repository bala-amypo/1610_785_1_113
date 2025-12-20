// package com.example.demo.repository;
// import java.util.Optional;

// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.StudentProfileEntity;

// @Repository
// public interface StudentProfileRepository extends JpaRepository<StudentProfileEntity,Long>{
//         Optional<StudentProfileEntity>findByStudentId(String studentId);
// }
    


package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    StudentProfile findByStudentId(String studentId);
}