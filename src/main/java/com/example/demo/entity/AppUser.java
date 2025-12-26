//  package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.Set;

// @Entity
// public class AppUser {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String email;

//     private String username;
//     private String password;

//     @ManyToMany(fetch = FetchType.EAGER)
//     private Set<Role> roles;

//     public AppUser() {
//     }

//     public AppUser(String email, String password) {
//         this.email = email;
//         this.password = password;
//     }



//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public Set<Role> getRoles() { return roles; }
//     public void setRoles(Set<Role> roles) { this.roles = roles; }

//     public String getEmail() {       // ✅ ADD
//         return email;
//     }

//     public void setEmail(String email) { // ✅ ADD
//         this.email = email;
//     }

// } 




package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String password;
    private String fullName;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
}