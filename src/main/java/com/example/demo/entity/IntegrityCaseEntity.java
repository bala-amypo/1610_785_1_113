package com.example.demo.entity;

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
}