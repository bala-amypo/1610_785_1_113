// package com.example.demo.entity;

// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;


// @Entity
// public class EvidenceRecordEntity{
//     @Id
//     @GeneratedValue(strategy=GenerationType.Identity)
//     private Long id;

//     private String evidenceType;
//     private String content;
//     private String submittedBy;
//     private LocalDateTime submittedAt;

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public String getEvidenceType(){
//         return evidenceType;
//     }
//     public void setEvidenceType(String evidenceType){
//         this.evidenceType=evidenceType;
//     }
//     public String getContent(){
//         return content;
//     }
//     public void setcontent(String content){
//         this.content=content;
//     }
//     public String getSubmittedBy(){
//         return submittedBy;
//     }
//     public void setSubmittedBy(String submittedBy){
//         this.submittedBy=submittedBy;
//     }
//     public LocalDateTime getSubmittedAt(){
//         return  submittedAt;
//     }
//     public void setSubmittedAt(LocalDateTime submittedAt){
//         this.submittedAt=submittedAt;
//     }

//     public EvidenceRecordEntity{}

//     public EvidenceRecordEntity(Long id,String evidenceType,String content,
//     String submittedBy,LocalDateTime submittedAt){
//         this.id=id;
//         this.evidenceType=evidenceType;
//         this.content=content;
//         this.submittedBy=submittedBy;
//         this.submittedAt=submittedAt;
//     }

// }


package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "evidence_record")
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private IntegrityCase integrityCase;

    private String evidenceType;
    private String content;
    private String submittedBy;
    private LocalDateTime submittedAt;

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public IntegrityCase getIntegrityCase() { return integrityCase; }
    public void setIntegrityCase(IntegrityCase integrityCase) { this.integrityCase = integrityCase; }

    public String getEvidenceType() { return evidenceType; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
}