package com.example.demo.entity;


import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

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
    
    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
        this.repeatOffender=false;
    }
}