 package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PenaltyAction;

public interface PenaltyActionService {

    PenaltyAction addPenalty(PenaltyAction penaltyAction);

    PenaltyAction getPenaltyById(Long id);

    List<PenaltyAction> getPenaltiesByCase(Long caseId);

    List<PenaltyAction> getAllPenalties();
} 