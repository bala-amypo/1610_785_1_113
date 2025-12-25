package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    // 1️⃣ create student
    @PostMapping
    public StudentProfile createStudent(@Valid @RequestBody StudentProfile student) {
        return service.createStudent(student);
    }

    // 2️⃣ get by id
    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // 3️⃣ get all students
    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return service.getAllStudents();
    }

    // 4️⃣ update repeat offender status
    @PutMapping("/{id}/repeat-status")
    public StudentProfile updateRepeatStatus(@PathVariable Long id) {
        return service.updateRepeatOffenderStatus(id);
    }

    // 5️⃣ get by studentIdentifier
    @GetMapping("/identifier/{studentIdentifier}")
    public StudentProfile getByStudentIdentifier(
            @PathVariable String studentIdentifier) {
        return service.getStudentByStudentIdentifier(studentIdentifier);
    }
} 