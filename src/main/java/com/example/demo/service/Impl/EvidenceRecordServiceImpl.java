package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    @Autowired
    private EvidenceRecordRepository evidenceRepo;

    @Autowired
    private IntegrityCaseRepository caseRepo;

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidence) {
        return evidenceRepo.save(evidence);
    }

    @Override
    public List<EvidenceRecord> getEvidenceByCase(Long caseId) {
        IntegrityCase ic = caseRepo.findById(caseId).orElse(null);
        return ic != null ? evidenceRepo.findByIntegrityCase(ic) : null;
    }

    @Override
    public EvidenceRecord getEvidenceById(Long id) {
        return evidenceRepo.findById(id).orElse(null);
    }

    @Override
    public List<EvidenceRecord> getAllEvidence() {
        return evidenceRepo.findAll();
    }
}  