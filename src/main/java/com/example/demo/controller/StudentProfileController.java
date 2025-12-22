
package com.example.demo.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService service;

    @PostMapping("p1")
    public StudentProfile createStudent(@Valid @RequestBody StudentProfile student) {
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping("g1")
    public List<StudentProfile> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("put1/{studentId}/repeat-status")
    public StudentProfile updateRepeatStatus(
            @PathVariable Long studentId,
            @RequestParam boolean status) {
        return service.updateRepeatStatus(studentId, status);
    }

    @GetMapping("ge1/lookup/{identifier}")
    public StudentProfile findByIdentifier(@PathVariable String identifier) {
        return service.findByStudentIdentifier(identifier);

    }



         @PostMapping("/studentProfile")
    public StudentProfile saveProfile(
            @Valid @RequestBody StudentProfile profile) {
        return service.postData(profile);
    }

    @GetMapping("/studentProfile/{id}")
    public StudentProfile getProfileById(@PathVariable Integer id) {
        return service.getData(id); // exception triggers here
    }
    
} 



