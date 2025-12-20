package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService{
        @Autowired StudentProfileRepository studdent;

        @Override
        public StudentProfileEntity postData(StudentProfileEntity stu){
            return
        }
    
}