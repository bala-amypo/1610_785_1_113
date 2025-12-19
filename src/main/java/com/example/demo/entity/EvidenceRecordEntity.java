package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class EvidenceRecordEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.Identity)
    private Long id;

    private String evidenceType;
    private String content;
    private String submittedBy;
    private LocalDateTime submittedAt;

    public EvidenceRecordEntity{}

    public EvidenceRecordEntity()
}