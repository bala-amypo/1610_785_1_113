package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    @Autowired
    private IntegrityCaseRepository caseRepo;

    @Autowired
    private StudentProfileRepository studentRepo;

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return caseRepo.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long id, String status) {
        IntegrityCase ic = caseRepo.findById(id).orElse(null);
        if (ic != null) {
            ic.setStatus(status);
            return caseRepo.save(ic);
        }
        return null;

      
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        StudentProfile sp = studentRepo.findById(studentId).orElse(null);
        return sp != null ? caseRepo.findByStudentProfile(sp) : List.of(); 
    }

    @Override
    public IntegrityCase getCaseById(Long id) {
        return caseRepo.findById(id).orElse(null);
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return caseRepo.findAll();
    }
}