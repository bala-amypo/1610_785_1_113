package com.example.demo.exception;

public class StudentProfileNotFoundException extends RuntimeException {

    public StudentProfileNotFoundException(String message) {
        super(message);
    }
}  package com.example.demo.service;

import com.example.demo.entity.StudentProfileEntity;

public interface StudentProfileService {

    StudentProfileEntity postData(StudentProfileEntity profile);

    StudentProfileEntity getData(Integer id);   // ID exception handled here
}
 package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.exception.StudentProfileNotFoundException;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository repo;

    @Override
    public StudentProfileEntity postData(StudentProfileEntity profile) {
        return repo.save(profile);
    }

    @Override
    public StudentProfileEntity getData(Integer id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new StudentProfileNotFoundException("StudentProfile ID not found : " + id));
    }
}                         package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentProfileNotFoundException.class)
    public ResponseEntity<String> handleStudentProfileException(
            StudentProfileNotFoundException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
 package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentProfileEntity;
import com.example.demo.service.StudentProfileService;

import jakarta.validation.Valid;

@RestController
public class StudentProfileController {

    @Autowired
    private StudentProfileService service;

    @PostMapping("/studentProfile")
    public StudentProfileEntity saveProfile(
            @Valid @RequestBody StudentProfileEntity profile) {
        return service.postData(profile);
    }

    @GetMapping("/studentProfile/{id}")
    public StudentProfileEntity getProfileById(@PathVariable Integer id) {
        return service.getData(id); // exception triggers here
    }
}
