// package com.example.demo.controller;

// import java.util.List;
// import java.util.Optional;

// import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.IntegrityCase;
// import com.example.demo.service.IntegrityCaseService;

// @RestController
// @RequestMapping("/cases")
// public class IntegrityCaseController {

//     private final IntegrityCaseService service;

//     public IntegrityCaseController(IntegrityCaseService service) {
//         this.service = service;
//     }

//     // create case
//     @PostMapping
//     public IntegrityCase createCase(@Valid @RequestBody IntegrityCase integrityCase) {
//         return service.createCase(integrityCase);
//     }

//     // update status
//     @PutMapping("/{id}/status")
//     public IntegrityCase updateStatus(
//             @PathVariable Long id,
//             @RequestParam String status) {
//         return service.updateCaseStatus(id, status);
//     }

//     // get by student
//     @GetMapping("/student/{studentId}")
//     public List<IntegrityCase> getCasesByStudent(@PathVariable Long studentId) {
//         return service.getCasesByStudent(studentId);
//     }

//     // get by id
//     @GetMapping("/{id}")
//     public Optional<IntegrityCase> getById(@PathVariable Long id) {
//         return service.getCaseById(id);
//     }

//     // get all
//     @GetMapping
//     public List<IntegrityCase> getAll() {
//         return service.getAllCases();
//     }
// }