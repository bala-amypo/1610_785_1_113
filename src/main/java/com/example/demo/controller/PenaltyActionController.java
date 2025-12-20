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

    @PostMapping("p3")
    public PenaltyAction addPenalty(@RequestBody PenaltyAction penalty) {
        return service.addPenalty(penalty);
    }

    @GetMapping("g3/case/{caseId}")
    public List<PenaltyAction> getPenaltiesByCase(@PathVariable Long caseId) {
        return service.getPenaltiesByCase(caseId);
    }

    @GetMapping("ge3/{id}")
    public PenaltyAction getPenaltyById(@PathVariable Long id) {
        return service.getPenaltyById(id);
    }

    @GetMapping("get3")
    public List<PenaltyAction> getAllPenalties() {
        return service.getAllPenalties();
    }
}