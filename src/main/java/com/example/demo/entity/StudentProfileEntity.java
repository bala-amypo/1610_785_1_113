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
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getProgram(){
        return program;
    }
    public void setProgram(String program){
        this.program=program;
    }
    public Integer getYearLevel(){
        return yearLevel;
    }
    public void setYearLevel(Integer yearLevel){
        this.yearLevel=yearLevel;
    }
    public Boolean getRepeatOffender(){
        return RepeatOffender;
    }
    public void setRepeatOffender(Boolean repeatOffender){
        this.repeatOffender=repeatOffender;
    }
    public LocalDateTime  getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }

    public StudentProfileEntity{}

}