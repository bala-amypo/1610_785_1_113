// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.RestController;
// // import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.beans.factory.annotation.Autowired;


// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import com.example.demo.service.IntegrityCaseService;
// import com.example.demo.entity.IntegrityCaseEntity;



// @RestController
// public class IntegrityCaseController{
//      @Autowired IntegrityCaseService ser;

//      @PostMapping("/p2")
//      public IntegrityCaseEntity sendData(@RequestBody IntegrityCaseEntity stu){
//         return ser.postData(stu);
//      }

//      @GetMapping("G2")
//      public List<IntegrityCaseEntity>getAll(){
//         return ser.getAllData();
//      }

//      @GetMapping("Ge2/{id}")
//      public IntegrityCaseEntity getById(@PathVariable Long id){
//         return ser.getStudentById(id);
//      }

//      @PutMapping("Put2/{id}/status")
//      public IntegrityCaseEntity updateRepeatStatus(@PathVariable Long id,@RequestBody String status){
//          return ser.updateRepeatStatus(id,status);
//      }

//      @GetMapping("Get2/student/{studentId}")
//      public List<IntegrityCaseEntity> getByStudentIdentifier(@PathVariable String studentId){
//         return ser.getByStudentIdentifier(studentId);
//      }

// }




package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {

    @Autowired
    private IntegrityCaseService service;

    @PostMapping("p4")
    public IntegrityCase createCase(@Valid @RequestBody IntegrityCase integrityCase) {
        return service.createCase(integrityCase);
    }

    @PutMapping("put4/{id}/status")
    public IntegrityCase updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("g4/student/{studentId}")
    public List<IntegrityCase> getCasesByStudent(@PathVariable Long studentId) {
        return service.getCasesByStudent(studentId);
    }

    @GetMapping("ge4/{id}")
    public IntegrityCase getCaseById(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping("get4")
    public List<IntegrityCase> getAllCases() {
        return service.getAllCases();
    }
}