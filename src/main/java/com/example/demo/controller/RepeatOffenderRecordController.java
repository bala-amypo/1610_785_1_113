package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    @Autowired
    private RepeatOffenderRecordService service;

    @PostMapping("p2/refresh/{studentId}")
    public RepeatOffenderRecord refreshRecord(@PathVariable Long studentId) {
        return service.refreshRepeatOffenderData(studentId);
    }

    @GetMapping("g2/student/{studentId}")
    public RepeatOffenderRecord getRecordByStudent(@PathVariable Long studentId) {
        return service.getRecordByStudent(studentId);
    }

    @GetMapping("ge2")
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return service.getAllRepeatOffenders();
    }
}   