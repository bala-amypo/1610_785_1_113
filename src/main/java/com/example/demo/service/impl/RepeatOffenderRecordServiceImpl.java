package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calculator;

    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentRepo,
            IntegrityCaseRepository caseRepo,
            RepeatOffenderRecordRepository recordRepo,
            RepeatOffenderCalculator calculator) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.recordRepo = recordRepo;
        this.calculator = calculator;
    }

    @Override
    public RepeatOffenderRecord generateRecord(Long studentId) {
        return calculateAndSave(studentId);
    }

    @Override
    public RepeatOffenderRecord recalculateRepeatOffender(Long studentId) {
        return calculateAndSave(studentId);
    }

    @Override
    public RepeatOffenderRecord getByStudentId(Long studentId) {
        return recordRepo.findByStudentProfileId(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return recordRepo.findAll();
    }

    // 🔁 shared logic
    private RepeatOffenderRecord calculateAndSave(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);

        RepeatOffenderRecord record =
                calculator.computeRepeatOffenderRecord(student, cases);

        return recordRepo.save(record);
    }
}
 