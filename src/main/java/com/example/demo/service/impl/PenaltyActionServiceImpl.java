// package com.example.demo.service.impl;

// import com.example.demo.entity.PenaltyAction;
// import com.example.demo.repository.PenaltyActionRepository;
// import com.example.demo.service.PenaltyActionService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class PenaltyActionServiceImpl implements PenaltyActionService {

//     @Autowired
//     private PenaltyActionRepository repository;

//     @Override
//     public List<PenaltyAction> getAllPenalties() {
//         return repository.findAll();
//     }

//     @Override
//     public PenaltyAction getPenaltyById(Long id) {
//         Optional<PenaltyAction> action = repository.findById(id);
//         return action.orElseThrow(() -> new RuntimeException("PenaltyAction not found with id: " + id));
//     }

//     @Override
//     public PenaltyAction savePenalty(PenaltyAction action) {
//         return repository.save(action);
//     }

//     @Override
//     public PenaltyAction updatePenalty(Long id, PenaltyAction action) {
//         PenaltyAction existingAction = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("PenaltyAction not found with id: " + id));

//         existingAction.setName(action.getName());
//         existingAction.setDescription(action.getDescription());
//         existingAction.setSeverity(action.getSeverity());

//         return repository.save(existingAction);
//     }

//     @Override
//     public void deletePenalty(Long id) {
//         repository.deleteById(id);
//     }
// }





package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    @Autowired
    private PenaltyActionRepository repository;

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        return repository.save(penalty);
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return repository.findAll();
    }

    @Override
    public PenaltyAction getPenaltyById(Long id) {
        Optional<PenaltyAction> penalty = repository.findById(id);
        return penalty.orElse(null); // or throw custom exception
    }

    @Override
    public List<PenaltyAction> getPenaltiesByCase(Long caseId) {
        return repository.findByIntegrityCaseId(caseId);
    }
} 