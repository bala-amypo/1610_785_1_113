// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.IntegrityCaseEntity;
// public interface IntegrityCaseService{
//      IntegrityCaseEntity postData(IntegrityCaseEntity stu);
//      List<IntegrityCaseEntity>getAllData(); //get all
//      IntegrityCaseEntity getStudentById(Long id);  //get by Id
//      IntegrityCaseEntity updateRepeatStatus(Long id,String status); //put repeat
//      List<IntegrityCaseEntity>getByStudentIdentifier(String studentId);  //lookup

// }



package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.IntegrityCase;

public interface IntegrityCaseService {

    IntegrityCase createCase(IntegrityCase integrityCase);

    IntegrityCase updateCaseStatus(Long id, String status);

    List<IntegrityCase> getCasesByStudent(Long studentId);

    IntegrityCase getCaseById(Long id);

    List<IntegrityCase> getAllCases();
}  