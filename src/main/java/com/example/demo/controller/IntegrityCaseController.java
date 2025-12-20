package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.StudentProfileService;
import com.example.demo.entity.StudentProfileEntity;



@RestController
public class IntegrityCaseController{
     @Autowired IntegrityCaseService ser;

     @PostMapping("/p2")
     public IntegrityCaseEntity sendData(@RequestBody IntegrityCaseEntity stu){
        return ser.postData(stu);
     }

     @GetMapping("G2")
     public List<IntegrityCaseEntity>getAll(){
        return ser.getAllData();
     }

     @GetMapping("Ge2/{id}")
     public IntegrityCaseEntity getById(@PathVariable Long id){
        return ser.getStudentById(id);
     }

     @PutMapping("Put2/{id}/status")
     public IntegrityCaseEntity updateRepeatStatus(@PathVariable Long id,@RequestBody String status){
         return ser.updateRepeatStatus(id,status);
     }

     @GetMapping("Get2/student/{studentId}")
     public List<StudentProfileEntity> getByStudentIdentifier(@PathVariable String studentId){
        return ser.getByStudentIdentifier(studentId);
     }

}