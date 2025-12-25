package com.example.demo.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {



     private final String jwtSecret = "mySecretKey";
    private final long jwtExpirationMs = 86400000; // 1 day

    // ✅ THIS METHOD MUST EXIST
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // private final String secretKey = "secret";
    // private final long validity = 86400000; // 1 day

    // public String generateToken(String email) {

    //     Date now = new Date();
    //     Date expiry = new Date(now.getTime() + validity);

    //     return Jwts.builder()
    //             .setSubject(email)
    //             .setIssuedAt(now)
    //             .setExpiration(expiry)
    //             .signWith(SignatureAlgorithm.HS256, secretKey)
    //             .compact();
    // }

    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}








