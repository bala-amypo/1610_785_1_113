

package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "studentProfile cannot be null")
    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    @NotBlank(message = "courseCode cannot be blank")
    private String courseCode;

    private String instructorName;

    private String description;

    private String status = "OPEN";

    @NotNull(message = "incidentDate cannot be null")
    private LocalDate incidentDate;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL)
    private List<EvidenceRecord> evidenceRecords;

    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL)
    private List<PenaltyAction> penalties;

    public IntegrityCase() {
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "OPEN";
        }
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