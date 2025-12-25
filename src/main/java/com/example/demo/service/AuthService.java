                                                                            
 package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.JwtResponse;

public interface AuthService {

    void register(AuthRequest request);

    JwtResponse login(AuthRequest request);
}