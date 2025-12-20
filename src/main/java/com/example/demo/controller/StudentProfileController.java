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

// import com.example.demo.service.StudentProfileService;
// import com.example.demo.entity.StudentProfileEntity;



// @RestController
// public class StudentProfileController{
//      @Autowired StudentProfileService ser;

//      @PostMapping("/p1")
//      public StudentProfileEntity sendData(@RequestBody StudentProfileEntity stu){
//         return ser.postData(stu);
//      }

//      @GetMapping("G1")
//      public List<StudentProfileEntity>getAll(){
//         return ser.getAllData();
//      }

//      @GetMapping("Ge1/{id}")
//      public StudentProfileEntity getById(@PathVariable Long id){
//         return ser.getStudentById(id);
//      }

//      @PutMapping("Put1/{studentId}/repeat")
//      public StudentProfileEntity updateRepeatStatus(@PathVariable String studentId,@RequestBody Boolean status){
//          return ser.updateRepeatStatus(studentId,status);
//      }

//      @GetMapping("Get1/lookup/{studentId}")
//      public StudentProfileEntity getByStudentIdentifier(@PathVariable String studentId){
//         return ser.getByStudentIdentifier(studentId);
//      }


// }



package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService service;

    @PostMapping("p1")
    public StudentProfile createStudent(@RequestBody StudentProfile student) {
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping("g1")
    public List<StudentProfile> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("put1/{studentId}/repeat-status")
    public StudentProfile updateRepeatStatus(
            @PathVariable Long studentId,
            @RequestParam boolean status) {
        return service.updateRepeatStatus(studentId, status);
    }

    @GetMapping("ge1/lookup/{identifier}")
    public StudentProfile findByIdentifier(@PathVariable String identifier) {
        return service.findByStudentIdentifier(identifier);
    }
} 