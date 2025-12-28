//  package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.RepeatOffenderRecord;
// import com.example.demo.service.RepeatOffenderRecordService;

// @RestController
// @RequestMapping("/repeat-offenders")
// public class RepeatOffenderRecordController {

//     private final RepeatOffenderRecordService service;

//     public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
//         this.service = service;
//     }

//     // recalculate
//     @PutMapping("/{studentId}")
//     public RepeatOffenderRecord recalculate(@PathVariable Long studentId) {
//         return service.recalculateRepeatOffender(studentId);
//     }

//     // get by student
//     @GetMapping("/student/{studentId}")
//     public RepeatOffenderRecord getByStudent(@PathVariable Long studentId) {
//         return service.getByStudentId(studentId);
//     }

//     // get all
//     @GetMapping
//     public List<RepeatOffenderRecord> getAll() {
//         return service.getAllRepeatOffenders();
//     }
// }
