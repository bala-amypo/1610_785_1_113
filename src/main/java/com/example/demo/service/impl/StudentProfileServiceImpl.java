package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calc;

    public StudentProfileServiceImpl(StudentProfileRepository repo,
                                     IntegrityCaseRepository caseRepo,
                                     RepeatOffenderRecordRepository recordRepo,
                                     RepeatOffenderCalculator calc) {
        this.repo = repo;
        this.caseRepo = caseRepo;
        this.recordRepo = recordRepo;
        this.calc = calc;
    }

    @Override
    public StudentProfile createStudent(StudentProfile s) {
        s.setRepeatOffender(false);
        return repo.save(s);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long id) {
        StudentProfile s = getStudentById(id);
        List<IntegrityCase> cases = caseRepo.findByStudentProfile(s);

        RepeatOffenderRecord record = calc.computeRepeatOffenderRecord(s, cases);
        recordRepo.save(record);

        s.setRepeatOffender(record.getTotalCases() >= 2);
        return repo.save(s);
    }

    @Override
    public StudentProfile getStudentByStudentIdentifier(String studentIdentifier) {
        return repo.findByStudentId(studentIdentifier)
                   .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}