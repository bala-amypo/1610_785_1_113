package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.*;

public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repo;
    private final StudentProfileRepository studentRepo;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repo, StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    public IntegrityCase createCase(IntegrityCase c) {
        if (c.getStudentProfile() == null || c.getStudentProfile().getId() == null)
            throw new IllegalArgumentException("Student missing");

        studentRepo.findById(c.getStudentProfile().getId())
                .orElseThrow(() -> new IllegalArgumentException("Student missing"));

        return repo.save(c);
    }

    public IntegrityCase updateCaseStatus(Long id, String status) {
        IntegrityCase c = repo.findById(id).orElseThrow();
        c.setStatus(status);
        return repo.save(c);
    }

    public List<IntegrityCase> getCasesByStudent(Long id) {
        return repo.findByStudentProfile_Id(id);
    }

    public Optional<IntegrityCase> getCaseById(Long id) {
        return repo.findById(id);
    }
}  