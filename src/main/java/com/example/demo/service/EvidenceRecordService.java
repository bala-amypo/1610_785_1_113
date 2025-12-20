package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.IntegrityCaseEntity;
public interface IntegrityCaseService{
     IntegrityCaseEntity postData(IntegrityCaseEntity stu);
     List<IntegrityCaseEntity>getAllData(); //get all
     IntegrityCaseEntity getStudentById(Long id);  //get by Id
     IntegrityCaseEntity updateRepeatStatus(Long Id,String status); //put repeat
     IntegrityCaseEntity getByStudentIdentifier(String studentId);  //lookup

}