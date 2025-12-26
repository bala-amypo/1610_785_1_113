//  package com.example.demo.dto;

// import jakarta.validation.constraints.NotBlank;

// public class RegisterRequest {

//     @NotBlank
//     private String email;

//     @NotBlank
//     private String password;

//     public RegisterRequest() {
//     }

//     public String getEmail() {
//         return email;
//     }
 
//     public void setEmail(String email) {
//         this.email = email;
//     }
 
//     public String getPassword() {
//         return password;
//     }
 
//     public void setPassword(String password) {
//         this.password = password;
//     }
// }



package com.example.demo.dto;

public class RegisterRequest {
    private String email;
    private String password;
    private String fullName;
    private String role;
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}