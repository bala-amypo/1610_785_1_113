package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.StudentProfileService;
import com.example.demo.entity.StudentProfileEntity;



@RestController
public class StudentProfileController{
     @Autowired StudentProfileService ser;

     @PostMapping("/p1")
     public StudentProfileEntity sendData(@RequestBody StudentProfileEntity stu){
        return ser.postData(stu);
     }

     @GetMapping("G1")
     public List<StudentProfileEntity>getAll(){
        return ser.getAllData();
     }

     @GetMapping("Ge1/{id}")
     public StudentProfileEntity getById(@PathVariable Long id){
        return ser.getStudentById(id);
     }

     @PutMapping("Put1/{studentId}/repeat")
     public StudentProfileEntity updateRepeatStatus(@PathVariable String studentId,@RequestParam Boolean status){
         return ser.updateRepeatStatus(studentId,status);
     }

     @GetMapping("Get1/")


}