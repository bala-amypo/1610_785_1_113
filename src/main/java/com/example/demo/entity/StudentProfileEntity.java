package com.example.demo.entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jalarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
public class StudentProfileEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String studentId;
    private String name;
    private String email;
    private String program;
    private Integer yearLevel;
    private Boolean repeatOffender=false;
    private LocalDateTime createdAt=LocalDateTime.now();


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String studentId){
        this.studentId=studentId;
    }
    public 
    public StudentProfileEntity{}

}