// package com.example.demo.entity;


// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Column;


// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import java.time.LocalDateTime;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class StudentProfileEntity{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique=true)
//     private String studentId;
//     private String name;
//     private String email;
//     private String program;
//     private Integer yearLevel;
//     private Boolean repeatOffender;
//     private LocalDateTime createdAt;

//     @PrePersist
//     public void onCreate(){
//         this.createdAt=LocalDateTime.now();
//         this.repeatOffender=false;
//     }

// }



package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String studentId;

    private String name;

    @Column(unique = true)
    private String email;

    private String program;

    @Column(nullable = false)
    private Integer yearLevel;

    private Boolean repeatOffender = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile")
    private List<IntegrityCase> integrityCases;

    public StudentProfile() {}

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

    public Long getId() { return id; }
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getProgram() { return program; }
    public Integer getYearLevel() { return yearLevel; }
    public Boolean getRepeatOffender() { return repeatOffender; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setRepeatOffender(Boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }
} 
