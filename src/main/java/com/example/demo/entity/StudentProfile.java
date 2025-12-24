package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "studentId cannot be blank")
    @Column(unique = true, nullable = false)
    private String studentId;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @Email(message = "invalid email")
    @Column(unique = true)
    private String email;

    private String program;

    @NotNull(message = "yearLevel cannot be null")
    private Integer yearLevel;

    private Boolean repeatOffender = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL)
    private List<IntegrityCase> integrityCases;

    public StudentProfile() {
    }

    public StudentProfile(String studentId, String name, String email, String program, Integer yearLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.repeatOffender = false;
    }

    // Getters & setters
    public Long getId() { return id; }
    public Boolean getRepeatOffender() { return repeatOffender; }
    public void setRepeatOffender(Boolean repeatOffender) { this.repeatOffender = repeatOffender; }
}














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
    @Max(value = 4, message = "Year level cannot exceed 4")
    private Integer yearLevel;

    private Boolean repeatOffender;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile")
    private List<IntegrityCase> integrityCases;

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