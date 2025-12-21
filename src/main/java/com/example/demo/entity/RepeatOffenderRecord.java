package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "repeat_offender_record")
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student profile is mandatory")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

    @NotNull(message = "Total cases is mandatory")
    @Min(value = 1, message = "Total cases must be at least 1")
    private Integer totalCases;

    @NotNull(message = "Last incident date is mandatory")
    private LocalDate lastIncidentDate;

    @NotBlank(message = "Flag severity is mandatory")
    private String flagSeverity;

    
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

    public Integer getTotalCases() {
         return totalCases; 
    }
    public void setTotalCases(Integer totalCases) {
         this.totalCases = totalCases; 
    }

    public LocalDate getLastIncidentDate() {
         return lastIncidentDate; 
    }
    public void setLastIncidentDate(LocalDate lastIncidentDate) { 
        this.lastIncidentDate = lastIncidentDate; 
    }

    public String getFlagSeverity() {
         return flagSeverity; 
    }
    public void setFlagSeverity(String flagSeverity) {
         this.flagSeverity = flagSeverity; 
    }

}