//  package com.example.demo.controller;

// import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.service.AuthService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthService service;

//     public AuthController(AuthService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public void register(@Valid @RequestBody AuthRequest request) {
//         service.register(request);
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@Valid @RequestBody AuthRequest request) {
//         return service.login(request);
//     }
// }



