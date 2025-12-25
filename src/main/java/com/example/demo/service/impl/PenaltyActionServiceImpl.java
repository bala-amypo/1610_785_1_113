package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    @Autowired
    private PenaltyActionRepository penaltyRepo;

    @Autowired
    private IntegrityCaseRepository caseRepo;

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        return penaltyRepo.save(penalty);
    }

    @Override
    public List<PenaltyAction> getPenaltiesByCase(Long caseId) {
        IntegrityCase ic = caseRepo.findById(caseId).orElse(null);
        return ic != null ? penaltyRepo.findByIntegrityCase(ic) : null;
    }

    @Override
    public PenaltyAction getPenaltyById(Long id) {
        return penaltyRepo.findById(id).orElse(null);
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return penaltyRepo.findAll();
    }
} 