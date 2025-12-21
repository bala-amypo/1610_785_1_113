package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {

    @Autowired
    private IntegrityCaseService service;

    @PostMapping("p4")
    public IntegrityCase createCase(@Valid @RequestBody IntegrityCase integrityCase) {
        return service.createCase(integrityCase);
    }

    @PutMapping("put4/{id}/status")
    public IntegrityCase updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("g4/student/{studentId}")
    public List<IntegrityCase> getCasesByStudent(@PathVariable Long studentId) {
        return service.getCasesByStudent(studentId);
    }

    @GetMapping("ge4/{id}")
    public IntegrityCase getCaseById(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping("get4")
    public List<IntegrityCase> getAllCases() {
        return service.getAllCases();
    }
}