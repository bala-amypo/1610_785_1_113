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
    public List<PenaltyAction> getAllActions() {
        return repository.findAll();
    }

    @Override
    public PenaltyAction getActionById(Long id) {
        Optional<PenaltyAction> action = repository.findById(id);
        return action.orElseThrow(() -> new RuntimeException("PenaltyAction not found with id: " + id));
    }

    @Override
    public PenaltyAction saveAction(PenaltyAction action) {
        return repository.save(action);
    }

    @Override
    public PenaltyAction updateAction(Long id, PenaltyAction action) {
        PenaltyAction existingAction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PenaltyAction not found with id: " + id));

        existingAction.setName(action.getName());
        existingAction.setDescription(action.getDescription());
        existingAction.setSeverity(action.getSeverity());

        return repository.save(existingAction);
    }

    @Override
    public void deleteAction(Long id) {
        repository.deleteById(id);
    }
}
