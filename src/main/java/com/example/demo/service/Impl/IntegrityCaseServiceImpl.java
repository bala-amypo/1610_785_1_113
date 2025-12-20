package com.example.demo.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IntegrityCaseEntity;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService{
        @Autowired IntegrityCaseRepository repo;

        @Override
        public IntegrityCaseEntity postData(IntegrityCaseEntity stu){
            return repo.save(stu);
        }

        @Override
        public List<IntegrityCaseEntity>getAllData(){
            return repo.findAll();
        }

        @Override
        public IntegrityCaseEntity getStudentById(Long id){
            return repo.findById(id).orElse(null);
        }

        @Override
        public IntegrityCaseEntity updateRepeatStatus(Long id,String status){
            IntegrityCaseEntity student=repo.findByStudentId(id).orElse(null);
            if(student !=null){
                student.setRepeatOffender(status);
                return repo.save(student);
            }
            return null;
        }
        @Override
        public List<IntegrityCaseEntity> getByStudentIdentifier(String studentId){
            return repo.findByStudentId(studentId);
        }   
}