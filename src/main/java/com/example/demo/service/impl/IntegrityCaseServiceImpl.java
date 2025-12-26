// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.IntegrityCaseService;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class IntegrityCaseServiceImpl implements IntegrityCaseService {

//     private final IntegrityCaseRepository repo;
//     private final StudentProfileRepository studentRepo;

//     public IntegrityCaseServiceImpl(IntegrityCaseRepository repo, StudentProfileRepository studentRepo) {
//         this.repo = repo;
//         this.studentRepo = studentRepo;
//     }

//     @Override
//     public IntegrityCase createCase(IntegrityCase c) {
//         if (c.getStudentProfile() == null || c.getStudentProfile().getId() == null)
//             throw new IllegalArgumentException("Student missing");

//         studentRepo.findById(c.getStudentProfile().getId())
//                    .orElseThrow(() -> new IllegalArgumentException("Student missing"));

//         return repo.save(c);
//     }

//     @Override
//     public IntegrityCase updateCaseStatus(Long id, String status) {
//         IntegrityCase c = repo.findById(id).orElseThrow();
//         c.setStatus(status);
//         return repo.save(c);
//     }

//     @Override
//     public List<IntegrityCase> getCasesByStudent(Long studentId) {
//         return repo.findByStudentProfile_Id(studentId);
//     }

//     @Override
//     public Optional<IntegrityCase> getCaseById(Long id) {
//         return repo.findById(id);
//     }

//     @Override
//     public List<IntegrityCase> getAllCases() {
//         return repo.findAll();
//     }
// }





package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {
    
    private final IntegrityCaseRepository integrityCaseRepository;
    private final StudentProfileRepository studentProfileRepository;
    
    public IntegrityCaseServiceImpl(IntegrityCaseRepository integrityCaseRepository,
                                  StudentProfileRepository studentProfileRepository) {
        this.integrityCaseRepository = integrityCaseRepository;
        this.studentProfileRepository = studentProfileRepository;
    }
    
    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        if (integrityCase.getStudentProfile() == null) {
            throw new IllegalArgumentException("Student profile is required");
        }
        
        // Validate student exists
        studentProfileRepository.findById(integrityCase.getStudentProfile().getId())
            .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        
        return integrityCaseRepository.save(integrityCase);
    }
    
    @Override
    public IntegrityCase updateCaseStatus(Long id, String status) {
        IntegrityCase integrityCase = integrityCaseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Case not found"));
        integrityCase.setStatus(status);
        return integrityCaseRepository.save(integrityCase);
    }
    
    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return integrityCaseRepository.findByStudentProfile_Id(studentId);
    }
    
    @Override
    public Optional<IntegrityCase> getCaseById(Long id) {
        return integrityCaseRepository.findById(id);
    }
}