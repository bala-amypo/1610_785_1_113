// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.StudentProfile;

// public interface StudentProfileService {

//     StudentProfile createStudent(StudentProfile studentProfile);

//     StudentProfile getStudentById(Long id);

//     List<StudentProfile> getAllStudents();

//     StudentProfile updateRepeatOffenderStatus(Long studentId);

//     StudentProfile getStudentByStudentIdentifier(String studentIdentifier); 
// }  


package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile s);
    StudentProfile getStudentById(Long id);
    List<StudentProfile> getAllStudents();
    StudentProfile updateRepeatOffenderStatus(Long studentId);
}



