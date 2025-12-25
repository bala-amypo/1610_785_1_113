package com.example.demo.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    // ✅ USE ONE SECRET KEY CONSISTENTLY
    private final String jwtSecret = "mySecretKey";
    private final long jwtExpirationMs = 86400000; // 1 day

    // ✅ GENERATE TOKEN
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // ✅ EXTRACT EMAIL FROM TOKEN
    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)   // ✅ FIXED HERE
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
