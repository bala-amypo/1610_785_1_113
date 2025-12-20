
package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository repo;

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        return repo.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentProfile updateRepeatStatus(Long studentId, boolean status) {
        StudentProfile student = repo.findById(studentId).orElse(null);
        if (student != null) {
            student.setRepeatOffender(status);
            return repo.save(student);
        }
        return null;
    }

    @Override
    public StudentProfile findByStudentIdentifier(String identifier) {
        return repo.findByStudentIdentifier(identifier);
    }
}