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
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profile")
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

    private Integer yearLevel;

    private Boolean repeatOffender;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile")
    private List<IntegrityCase> integrityCases;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.isRepeatOffender = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public Integer getYearLevel() { return yearLevel; }
    public void setYearLevel(Integer yearLevel) { this.yearLevel = yearLevel; }

    public Boolean getIsRepeatOffender() { return isRepeatOffender; }
    public void setIsRepeatOffender(Boolean isRepeatOffender) { this.isRepeatOffender = isRepeatOffender; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}