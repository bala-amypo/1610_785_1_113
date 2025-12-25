package com.example.demo.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;

@Service  // ✅ IMPORTANT
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider tokenProvider;

    // ✅ CONSTRUCTOR INJECTION (CORRECT)
    public AuthServiceImpl(
            AppUserRepository userRepo,
            RoleRepository roleRepo,
            PasswordEncoder encoder,
            AuthenticationManager authManager,
            JwtTokenProvider tokenProvider) {

        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.tokenProvider = tokenProvider;
    }

    // ✅ REGISTER
    @Override
    public void register(AuthRequest request) {

        if (userRepo.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Role role = roleRepo.findByName("USER")
                .orElseThrow(() ->
                        new IllegalArgumentException("Role not found"));

        AppUser user = new AppUser(
                request.getEmail(),
                encoder.encode(request.getPassword())
        );

        user.getRoles().add(role);
        userRepo.save(user);
    }

    // ✅ LOGIN
    @Override
    public AuthResponse login(AuthRequest request) {

        // authenticate credentials
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        AppUser user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid credentials"));

        String role = user.getRoles().iterator().next().getName();

        // ✅ CORRECT TOKEN GENERATION (NO EXTRA ARGUMENTS)
        String token = tokenProvider.generateToken(user.getEmail());

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                role
        );
    }
}
