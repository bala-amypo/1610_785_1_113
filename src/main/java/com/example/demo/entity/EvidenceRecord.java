package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidence_record")
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//     @NotNull(message = "Integrity case is mandatory")
//     @ManyToOne
//     @JoinColumn(name = "case_id")
//     private IntegrityCase integrityCase;

    @NotBlank(message = "Evidence type is mandatory")
    private String evidenceType;

    @NotBlank(message = "Evidence content is mandatory")
    private String content;

    @NotBlank(message = "Submitted by is mandatory")
    private String submittedBy;

    private LocalDateTime submittedAt;

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
    }


    public Long getId() {
         return id; 
    }
    public void setId(Long id) {
         this.id = id; 
    }

//     public IntegrityCase getIntegrityCase() { 
//         return integrityCase; 
//     }
//     public void setIntegrityCase(IntegrityCase integrityCase) { 
//         this.integrityCase = integrityCase; 
//     }

    public String getEvidenceType() {
         return evidenceType; 
    }
    public void setEvidenceType(String evidenceType) { 
         this.evidenceType = evidenceType; 
    }

    public String getContent() {
         return content; 
    }
    public void setContent(String content) {
         this.content = content; 
    }

    public String getSubmittedBy() {
         return submittedBy; 
    }
    public void setSubmittedBy(String submittedBy) {
         this.submittedBy = submittedBy; 
    }

    public LocalDateTime getSubmittedAt() { 
        return submittedAt; 
    }
}