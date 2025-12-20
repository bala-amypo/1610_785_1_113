// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.StudentProfileEntity;
// public interface StudentProfileService{
//      StudentProfileEntity postData(StudentProfileEntity stu);
//      List<StudentProfileEntity>getAllData(); //get all
//      StudentProfileEntity getStudentById(Long id);  //get by Id
//      StudentProfileEntity updateRepeatStatus(String studentId,Boolean status); //put repeat
//      StudentProfileEntity getByStudentIdentifier(String studentId);  //lookup

// }



package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile student);

    StudentProfile getStudentById(Long id);

    List<StudentProfile> getAllStudents();

    StudentProfile updateRepeatStatus(Long studentId, boolean status);

    StudentProfile findByStudentIdentifier(String identifier);
}  