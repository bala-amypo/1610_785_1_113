// package com.example.demo.entity;


// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;


// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import java.time.LocalDateTime;
// import java.time.LocalDate;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor

// @Table(name="integrity_case")
// public class IntegrityCaseEntity{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String courseCode;
//     private String instructorName;
//     private String description;
//     private String status;
//     private LocalDate incidentDate;
//     private LocalDateTime createdAt;

//     @ManyToOne
//     @JoinColumn(name="student_id")
//     private StudentProfile studentProfile;
    
//     @PrePersist
//     public void setDefaults(){
//         this.createdAt=LocalDateTime.now();
//         if(this.status==null){
//            this.status="OPEN";
//       }
//     }
// }



package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "integrity_case")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

    private String courseCode;
    private String instructorName;
    private String description;
    private String status;
    private LocalDate incidentDate;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getIncidentDate() { return incidentDate; }
    public void setIncidentDate(LocalDate incidentDate) { this.incidentDate = incidentDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}