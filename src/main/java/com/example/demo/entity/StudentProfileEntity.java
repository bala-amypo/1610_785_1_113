package com.example.demo.entity;

// import java.time.LocalDateTime;
// import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jalarta.persistence.GenerationType;
import jakarta.persistence.Entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String name;
    private String email;
    private String program;
    private Integer yearLevel;
    private Boolean repeatOffender=false;
    private LocalDateTime createdAt=LocalDateTime.now();

}