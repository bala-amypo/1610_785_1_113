// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;
// import com.example.demo.entity.IntegrityCase;

// public interface IntegrityCaseService {

//     IntegrityCase createCase(IntegrityCase integrityCase);

//     IntegrityCase updateCaseStatus(Long caseId, String status);

//     List<IntegrityCase> getCasesByStudent(Long studentId);

//     Optional<IntegrityCase> getCaseById(Long id);

//     List<IntegrityCase> getAllCases();
// } 




package com.example.demo.service;

import com.example.demo.entity.IntegrityCase;
import java.util.List;
import java.util.Optional;

public interface IntegrityCaseService {
    IntegrityCase createCase(IntegrityCase integrityCase);
    IntegrityCase updateCaseStatus(Long id, String status);
    List<IntegrityCase> getCasesByStudent(Long studentId);
    Optional<IntegrityCase> getCaseById(Long id);
}