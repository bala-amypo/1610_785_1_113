package com.example.demo.service;

import com.example.demo.entity.StudentProfileEntity;
public interface StudentProfileService{
     StudentProfileEntity postData(StudentProfileEntity stu);
     List<StudentProfileEntity>getAllData(); //get all
     StudentProfileEntity getStudentById(Long id);  //get by Id
     StudentProfileEntity updateRepeatStatus(String studentId,Boolean status); //put repeat
     StudentProfileEntity getByStudentIdentifier(String studentId);  //lookup

}