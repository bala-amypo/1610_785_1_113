package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    @Autowired
    private EvidenceRecordService service;

    @PostMapping
    public EvidenceRecord submitEvidence(@RequestBody EvidenceRecord evidence) {
        return service.submitEvidence(evidence);
    }

    @GetMapping("/case/{caseId}")
    public List<EvidenceRecord> getEvidenceByCase(@PathVariable Long caseId) {
        return service.getEvidenceByCase(caseId);
    }

    @GetMapping("/{id}")
    public EvidenceRecord getEvidenceById(@PathVariable Long id) {
        return service.getEvidenceById(id);
    }

    @GetMapping
    public List<EvidenceRecord> getAllEvidence() {
        return service.getAllEvidence();
    }
}