
package com.example.demo.service;

import com.example.demo.entity.PenaltyAction;
import java.util.List;

public interface PenaltyActionService {

    List<PenaltyAction> getAllPenalties(); // must match impl method name

    PenaltyAction getPenaltyById(Long id);

    PenaltyAction savePenalty(PenaltyAction action);

    PenaltyAction updatePenalty(Long id, PenaltyAction action);

    void deletePenalty(Long id);
}  