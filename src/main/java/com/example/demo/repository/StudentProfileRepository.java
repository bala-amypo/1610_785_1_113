package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StudentProfileEntity;
public interface StudentProfileRepository extends JpaRepository<StudentProfileEntity,Long>{

}
    
}