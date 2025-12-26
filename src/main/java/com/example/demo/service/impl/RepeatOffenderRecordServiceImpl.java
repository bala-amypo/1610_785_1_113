// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.RepeatOffenderRecordService;
// import com.example.demo.util.RepeatOffenderCalculator;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

//     private final StudentProfileRepository studentRepo;
//     private final IntegrityCaseRepository caseRepo;
//     private final RepeatOffenderRecordRepository recordRepo;
//     private final RepeatOffenderCalculator calculator;

//     public RepeatOffenderRecordServiceImpl(
//             StudentProfileRepository studentRepo,
//             IntegrityCaseRepository caseRepo,
//             RepeatOffenderRecordRepository recordRepo,
//             RepeatOffenderCalculator calculator) {
//         this.studentRepo = studentRepo;
//         this.caseRepo = caseRepo;
//         this.recordRepo = recordRepo;
//         this.calculator = calculator;
//     }

//     @Override
//     public RepeatOffenderRecord generateRecord(Long studentId) {
//         return calculateAndSave(studentId);
//     }

//     @Override
//     public RepeatOffenderRecord recalculateRepeatOffender(Long studentId) {
//         return calculateAndSave(studentId);
//     }

//     @Override
//     public RepeatOffenderRecord getByStudentId(Long studentId) {
//         return recordRepo.findByStudentProfileId(studentId)
//                 .orElseThrow(() -> new IllegalArgumentException("Record not found"));
//     }

//     @Override
//     public List<RepeatOffenderRecord> getAllRepeatOffenders() {
//         return recordRepo.findAll();
//     }

//     // 🔁 shared logic
//     private RepeatOffenderRecord calculateAndSave(Long studentId) {
//         StudentProfile student = studentRepo.findById(studentId)
//                 .orElseThrow(() -> new IllegalArgumentException("Student not found"));

//         List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);

//         RepeatOffenderRecord record =
//                 calculator.computeRepeatOffenderRecord(student, cases);

//         return recordRepo.save(record);
//     }
// }
 






 package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    
    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator calculator;
    
    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentProfileRepository,
                                         IntegrityCaseRepository integrityCaseRepository,
                                         RepeatOffenderRecordRepository repeatOffenderRecordRepository,
                                         RepeatOffenderCalculator calculator) {
        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.calculator = calculator;
    }
    
    @Override
    public RepeatOffenderRecord updateRecord(Long studentId) {
        StudentProfile student = studentProfileRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        
        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile(student);
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, cases);
        
        return repeatOffenderRecordRepository.save(record);
    }
}