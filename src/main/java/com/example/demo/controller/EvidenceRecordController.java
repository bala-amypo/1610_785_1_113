//  package com.example.demo.controller;

// import java.util.List;

// import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.EvidenceRecord;
// import com.example.demo.service.EvidenceRecordService;

// @RestController
// @RequestMapping("/evidence")
// public class EvidenceRecordController {

//     private final EvidenceRecordService service;

//     public EvidenceRecordController(EvidenceRecordService service) {
//         this.service = service;
//     }

//     // submit evidence
//     @PostMapping
//     public EvidenceRecord submit(@Valid @RequestBody EvidenceRecord record) {
//         return service.submitEvidence(record);
//     }

//     // get by id
//     @GetMapping("/{id}")
//     public EvidenceRecord getById(@PathVariable Long id) {
//         return service.getEvidenceById(id);
//     }

//     // get by case
//     @GetMapping("/case/{caseId}")
//     public List<EvidenceRecord> getByCase(@PathVariable Long caseId) {
//         return service.getEvidenceByCase(caseId);
//     }

//     // get all
//     @GetMapping
//     public List<EvidenceRecord> getAll() {
//         return service.getAllEvidence();
//     }
// } 