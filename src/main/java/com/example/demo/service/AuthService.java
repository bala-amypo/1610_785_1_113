//  package com.example.demo.service;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;

// public interface AuthService {

//     void register(AuthRequest request);

//     AuthResponse login(AuthRequest request);
// }


package com.example.demo.service;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

public interface AuthService {

    // Register new user
    void register(RegisterRequest request);

    // Login user and return JWT
    JwtResponse login(LoginRequest request);
}
