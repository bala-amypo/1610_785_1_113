package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;

@Service  // make it a Spring bean
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository repeatRepo;
    private final RepeatOffenderCalculator calculator;

    // 🔥 EXACT constructor order (DI tests depend on this)
    public StudentProfileServiceImpl(
            StudentProfileRepository studentRepo,
            IntegrityCaseRepository caseRepo,
            RepeatOffenderRecordRepository repeatRepo,
            RepeatOffenderCalculator calculator) {

        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.repeatRepo = repeatRepo;
        this.calculator = calculator;
    }

    // 1️⃣ Create student
    @Override
    public StudentProfile createStudent(StudentProfile studentProfile) {
        studentProfile.setRepeatOffender(false);
        return studentRepo.save(studentProfile);
    }

    // 2️⃣ Get by ID
    @Override
    public StudentProfile getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    // 3️⃣ Get all students
    @Override
    public List<StudentProfile> getAllStudents() {
        return studentRepo.findAll();
    }

    // 4️⃣ Update repeat offender status
    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {

        StudentProfile student = getStudentById(studentId);
        List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);

        RepeatOffenderRecord record =
                calculator.computeRepeatOffenderRecord(student, cases);

        repeatRepo.save(record);

        student.setRepeatOffender(record.getTotalCases() >= 2);
        return studentRepo.save(student);
    }

    // 5️⃣ Get by studentId (repository method updated)
    @Override
    public StudentProfile getStudentByStudentIdentifier(String studentId) {
        return studentRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}
