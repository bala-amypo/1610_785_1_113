 package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;

public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository repeatRepo;
    private final RepeatOffenderCalculator calculator;

    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentRepo,
            IntegrityCaseRepository caseRepo,
            RepeatOffenderRecordRepository repeatRepo,
            RepeatOffenderCalculator calculator) {

        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.repeatRepo = repeatRepo;
        this.calculator = calculator;
    }

    @Override
    public RepeatOffenderRecord recalculateRepeatOffender(Long studentId) {

        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);

        RepeatOffenderRecord record =
                calculator.computeRepeatOffenderRecord(student, cases);

        repeatRepo.save(record);

        student.setRepeatOffender(record.getTotalCases() >= 2);
        studentRepo.save(student);

        return record;
    }

    @Override
    public RepeatOffenderRecord getByStudentId(Long studentId) {

        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return repeatRepo.findByStudentProfile(student)
                .orElseThrow(() -> new ResourceNotFoundException("Repeat record not found"));
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return repeatRepo.findAll();
    }
}
 