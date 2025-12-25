  package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;

public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository caseRepo;
    private final StudentProfileRepository studentRepo;

    public IntegrityCaseServiceImpl(
            IntegrityCaseRepository caseRepo,
            StudentProfileRepository studentRepo) {

        this.caseRepo = caseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        if (integrityCase.getStudentProfile() == null) {
            throw new IllegalArgumentException("StudentProfile required");
        }
        return caseRepo.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase c = caseRepo.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found"));
        c.setStatus(status);
        return caseRepo.save(c);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        StudentProfile s = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return caseRepo.findByStudentProfile(s);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long id) {
        return caseRepo.findById(id);
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return caseRepo.findAll();
    }
}