package com.example.demo.repository;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.IntegrityCaseEntity;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCaseEntity,Long>{
        List<IntegrityCaseEntity>findByStudentProfile_StudentId(String studentId);
}
    

