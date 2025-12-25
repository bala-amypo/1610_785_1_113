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

    @NotBlank(message = "StudentId cannot be blank")
    @Column(unique = true, nullable = false)
    private String studentId;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    private String program;

    @NotNull(message = "Year level cannot be null")
    private Integer yearLevel;

    private Boolean repeatOffender = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL)
    private List<IntegrityCase> integrityCases;

    public StudentProfile() {}

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.repeatOffender = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
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
    public Boolean getRepeatOffender() { return repeatOffender; }
    public void setRepeatOffender(Boolean repeatOffender) { this.repeatOffender = repeatOffender; }
    public LocalDateTime getCreatedAt() { return createdAt; }
} 