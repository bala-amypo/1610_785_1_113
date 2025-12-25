 package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;

@RestController
@RequestMapping("/penalties")
public class PenaltyActionController {

    private final PenaltyActionService service;

    public PenaltyActionController(PenaltyActionService service) {
        this.service = service;
    }

    // add penalty
    @PostMapping
    public PenaltyAction add(@Valid @RequestBody PenaltyAction action) {
        return service.addPenalty(action);
    }

    // get by id
    @GetMapping("/{id}")
    public PenaltyAction getById(@PathVariable Long id) {
        return service.getPenaltyById(id);
    }

    // get by case
    @GetMapping("/case/{caseId}")
    public List<PenaltyAction> getByCase(@PathVariable Long caseId) {
        return service.getPenaltiesByCase(caseId);
    }

    // get all
    @GetMapping
    public List<PenaltyAction> getAll() {
        return service.getAllPenalties();
    }
}





package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    @Autowired
    private PenaltyActionRepository repository;

    @Override
    public List<PenaltyAction> getAllActions() {
        return repository.findAll();
    }

    @Override
    public PenaltyAction saveAction(PenaltyAction action) {
        return repository.save(action);
    }
} 