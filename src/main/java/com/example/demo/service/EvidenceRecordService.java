package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.IntegrityCaseEntity;
public interface IntegrityCaseService{
     IntegrityCaseEntity postData(StudentProfileEntity stu);
     List<StudentProfileEntity>getAllData(); //get all
     StudentProfileEntity getStudentById(Long id);  //get by Id
     StudentProfileEntity updateRepeatStatus(String studentId,Boolean status); //put repeat
     StudentProfileEntity getByStudentIdentifier(String studentId);  //lookup

}