package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;



@Service 
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRepo;
    private final IntegrityCaseRepository caseRepo;

    public EvidenceRecordServiceImpl(
            EvidenceRecordRepository evidenceRepo,
            IntegrityCaseRepository caseRepo) {

        this.evidenceRepo = evidenceRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {

        Long caseId = evidenceRecord.getIntegrityCase().getId();
        IntegrityCase c = caseRepo.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found"));

        evidenceRecord.setIntegrityCase(c);
        return evidenceRepo.save(evidenceRecord);
    }

    @Override
    public EvidenceRecord getEvidenceById(Long id) {
        return evidenceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evidence not found"));
    }

    @Override
    public List<EvidenceRecord> getEvidenceByCase(Long caseId) {
        IntegrityCase c = caseRepo.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found"));
        return evidenceRepo.findByIntegrityCase(c);
    }

    @Override
    public List<EvidenceRecord> getAllEvidence() {
        return evidenceRepo.findAll();
    }
}