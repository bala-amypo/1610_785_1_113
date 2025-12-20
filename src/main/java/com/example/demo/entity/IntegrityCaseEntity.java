// package com.example.demo.entity;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

// @Entity
// public class IntegrityCaseEntity{
//     @Id
//     @GeneratedValue(strategy=GenerationType.Identity)
//     private Long id;
//     private String courseCode;
//     private String instructorName;
//     private String description;
//     private String status;
//     private LocalDate incidentDate;
//     private LocalDateTime createdAt;

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public String getCourseCode(){
//          return courseCode;
//     }
//     public void setCourseCode(String courseCode){
//          this.courseCode=courseCode;

//     }
//     public String getInstructorName(){
//           return instructorName;
//     }
//     public void setInstructorName(String instructorName){
//           this.instructorName=instructorName;
//     }
//     public  string getDescription(){
//         return description;
//     }
//     public void setDescription(String description){
//         this.description=description;
//     }
//     public String getStatus(){
//         return status;
//     }
//     public void setStatus(String status){
//         this.status=status;
//     }
//     public LocalDate getIncidentDate(){
//         return  incidentDate;
//     }
//     public void setIncidentDate(LocalDate incidentDate){
//         this.incidentDate=incidentDate;
//     }
//     public LocalDateTime getCreatedAt(){
//         return  createdAt;
//     }
//     public void setCreatedAt(LocalDateTime createdAt){
//          this.createdAt=createdAt;
//     }


//     public IntegrityCaseEntity{}

//     public IntegrityCaseEntity(Long id,String courseCode,String instructorName,
//     String description,String status,LocalDate incidentDate,LocalDateTime createdAt){
//         this.id=id;
//         this.courseCode=courseCode;
//         this.instructorName=instructorName;
//         this.description=description;
//         this.status=status;
//         this.incidentDate=incidentDate;
//         this.createdAt=createdAt;
//     }
// }