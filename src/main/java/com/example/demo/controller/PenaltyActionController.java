package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyActionController {

    @Autowired
    private PenaltyActionService service;

    @PostMapping
    public PenaltyAction addPenalty(@RequestBody PenaltyAction penalty) {
        return service.addPenalty(penalty);
    }

    @GetMapping("/case/{caseId}")
    public List<PenaltyAction> getPenaltiesByCase(@PathVariable Long caseId) {
        return service.getPenaltiesByCase(caseId);
    }

    @GetMapping("/{id}")
    public PenaltyAction getPenaltyById(@PathVariable Long id) {
        return service.getPenaltyById(id);
    }

    @GetMapping
    public List<PenaltyAction> getAllPenalties() {
        return service.getAllPenalties();
    }
}