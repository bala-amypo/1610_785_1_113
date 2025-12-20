package com.example.demo.service.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    @Autowired
    private RepeatOffenderRecordRepository recordRepo;

    @Autowired
    private StudentProfileRepository studentRepo;

    @Override
    public RepeatOffenderRecord refreshRepeatOffenderData(Long studentId) {
        StudentProfile sp = studentRepo.findById(studentId).orElse(null);
        if (sp == null) return null;

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(sp);
        record.setTotalCases(1);
        record.setLastIncidentDate(LocalDate.now());
        record.setFlagSeverity("LOW");

        return recordRepo.save(record);
    }

    @Override
    public RepeatOffenderRecord getRecordByStudent(Long studentId) {
        StudentProfile sp = studentRepo.findById(studentId).orElse(null);
        return sp != null ? recordRepo.findByStudentProfile(sp) : null;
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return recordRepo.findAll();
    }
} 