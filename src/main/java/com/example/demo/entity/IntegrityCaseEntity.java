package com.example.demo.entity;


import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="integrity_case")
public class IntegrityCaseEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String instructorName;
    private String description;
    private String status;
    private LocalDate incidentDate;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="student_id")
    private StudentProfile studentProfile;
    
    @PrePersist
    public void setDefaults(){
        this.createdAt=LocalDateTime.now();
        if(this.status==null){
           this.status="OPEN";
      }
    }
}
