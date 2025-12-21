package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student identifier is mandatory")
    @Column(unique = true, nullable = false)
    private String studentId;

    @NotBlank(message = "Student name is mandatory")
    private String name;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Program is mandatory")
    private String program;

    @NotNull(message = "Year level is mandatory")
    @Min(value = 1, message = "Year level must be at least 1")
    @Max(value = 8, message = "Year level cannot exceed 8")
    private Integer yearLevel;

    private Boolean repeatOffender;

    private LocalDateTime createdAt;

//     @OneToMany(mappedBy = "studentProfile")
//     private List<IntegrityCase> integrityCases;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.repeatOffender = false;
    }

    
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) {
     this.id = id; 
    }

    public String getStudentId() {
     return studentId;
    }
    public void setStudentId(String studentId) {
     this.studentId = studentId; 
    }

    public String getName() {
         return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public String getEmail() {
         return email; 
    }
    public void setEmail(String email) {
     this.email = email; 
    }

    public String getProgram() {
         return program; 
    }
    public void setProgram(String program) {
         this.program = program; 
    }

    public Integer getYearLevel() {
         return yearLevel; 
    }
    public void setYearLevel(Integer yearLevel) {
         this.yearLevel = yearLevel; 
    }

    public Boolean getRepeatOffender() {
         return repeatOffender; 
    }
    public void setRepeatOffender(Boolean repeatOffender) { 
        this.repeatOffender = repeatOffender; 
    }

    public LocalDateTime getCreatedAt() {
         return createdAt; 
    }
    
}