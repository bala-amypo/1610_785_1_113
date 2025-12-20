package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService{
        @Autowired StudentProfileRepository student;

        @Override
        public StudentProfileEntity postData(StudentProfileEntity stu){
            return student.save(stu);
        }

        @Override
        public 
    
}