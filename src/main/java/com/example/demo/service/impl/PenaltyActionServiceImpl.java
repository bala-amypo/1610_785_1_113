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

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {
    
    private final PenaltyActionRepository penaltyActionRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    
    public PenaltyActionServiceImpl(PenaltyActionRepository penaltyActionRepository,
                                  IntegrityCaseRepository integrityCaseRepository) {
        this.penaltyActionRepository = penaltyActionRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }
    
    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        IntegrityCase integrityCase = integrityCaseRepository.findById(penalty.getIntegrityCase().getId())
            .orElseThrow(() -> new RuntimeException("Case not found"));
        
        integrityCase.setStatus("UNDER_REVIEW");
        integrityCaseRepository.save(integrityCase);
        
        return penaltyActionRepository.save(penalty);
    }
}