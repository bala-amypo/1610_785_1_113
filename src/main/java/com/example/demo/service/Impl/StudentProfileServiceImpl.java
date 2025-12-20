package com.example.demo.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService{
        @Autowired StudentProfileRepository repo;

        @Override
        public StudentProfileEntity postData(StudentProfileEntity stu){
            return repo.save(stu);
        }

        @Override
        public List<StudentProfileEntity>getAllData(){
            return repo.findAll();
        }

        @Override
        public StudentProfileEntity getStudentById(Long id){
            return repo.findById(id).orElse(null);
        }

        @Override
        public StudentProfileEntity updateRepeatStatus(String studentId,Boolean status){
            StudentProfileEntity student=repo.findByStudentId(studentId).orElse(null);
            if(student !=null){
                student.setRepeatOffender(status);
                return repo.save(student);
            }
            return null;
        }
        @Override
        public StudentProfileEntity getByStudentIdentifier(String studentId){
            return repo.findByStudentId(studentId).orElse(null);
        }

    
}