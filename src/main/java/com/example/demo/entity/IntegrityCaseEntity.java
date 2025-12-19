package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class IntegrityCaseEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.Identity)
    private Long id;
    private String courseCode;
    private String instructorName;
    private String description;
    private String status;
    private LocalDate incidentDate;
    private LocalDateTime createdAt;

    public IntegrityCaseEntity{}

    public IntegrityCaseEntity(Long id,String courseCode,String instructorName,
    String description,String status,LocalDate incidentDate,LocalDateTime createdAt){
        this.
        this.
        this.
        this.
        this.
         this.
    }
}