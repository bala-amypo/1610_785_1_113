 package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "penalty_action")
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   //  @NotNull(message = "Integrity case is mandatory")
   //  @ManyToOne
   //  @JoinColumn(name = "case_id")
   //  private IntegrityCase integrityCase;

    @NotBlank(message = "Penalty type is mandatory")
    private String penaltyType;

    @NotBlank(message = "Penalty details are mandatory")
    private String details;

    @NotBlank(message = "Issued by is mandatory")
    private String issuedBy;

    private LocalDateTime issuedAt;

    @PrePersist
    public void prePersist() {
        this.issuedAt = LocalDateTime.now();
    }

    public Long getId() {
       return id; 
    }
    public void setId(Long id) {
       this.id = id; 
    }

    public IntegrityCase getIntegrityCase() {
       return integrityCase; 
    }
    public void setIntegrityCase(IntegrityCase integrityCase) { 
       this.integrityCase = integrityCase; 
    }

    public String getPenaltyType() { 
       return penaltyType; 
    }
    public void setPenaltyType(String penaltyType) { 
       this.penaltyType = penaltyType; 
    }

    public String getDetails() { 
       return details; 
    }
    public void setDetails(String details) {
       this.details = details; 
    }

    public String getIssuedBy() {
       return issuedBy; 
    }
    public void setIssuedBy(String issuedBy) {
       this.issuedBy = issuedBy; 
    }

    public LocalDateTime getIssuedAt() { 
       return issuedAt; 
    }
}