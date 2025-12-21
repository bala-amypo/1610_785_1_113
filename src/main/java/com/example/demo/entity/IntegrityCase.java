package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "integrity_case")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student profile is mandatory")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

    @NotBlank(message = "Course code is mandatory")
    private String courseCode;

    @NotBlank(message = "Instructor name is mandatory")
    private String instructorName;

    @NotBlank(message = "Case description is mandatory")
    private String description;

    private String status;

    @NotNull(message = "Incident date is mandatory")
    private LocalDate incidentDate;

    private LocalDateTime createdAt;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public StudentProfile getStudentProfile() { 
        return studentProfile; 
    }
    public void setStudentProfile(StudentProfile studentProfile) {
         this.studentProfile = studentProfile; 
    }

    public String getCourseCode() { 
        return courseCode; 
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode; 
    }

    public String getInstructorName() {
        return instructorName; 
    }
    public void setInstructorName(String instructorName) { 
         this.instructorName = instructorName; 
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) {
         this.description = description; 
    }

    public String getStatus() {
         return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    public LocalDate getIncidentDate() { 
        return incidentDate; 
    }
    public void setIncidentDate(LocalDate incidentDate) {
         this.incidentDate = incidentDate; 
    }

    public LocalDateTime getCreatedAt() {
         return createdAt; 
    }
}