// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final byte[] secret;
//     private final long expirationMs;

//     // Spring uses this
//     public JwtTokenProvider() {
//         this.secret = "MyVerySecretKeyForJwt123456789012345".getBytes();
//         this.expirationMs = 60000L;
//     }

//     // Tests use this
//     public JwtTokenProvider(String secret, Long expirationMs) {
//         this.secret = secret.getBytes();
//         this.expirationMs = expirationMs;
//     }

//     public String generateToken(Authentication auth, Long userId, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     // 🔥 REQUIRED BY JwtAuthenticationFilter
//     public String getEmailFromToken(String token) {
//         return getUsernameFromToken(token);
//     }

//     public String getUsernameFromToken(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser()
//                     .setSigningKey(secret)
//                     .parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }
// }






package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {
    
    private final SecretKey key;
    private final long jwtExpirationInMs;
    
    public JwtTokenProvider() {
        this("MyVerySecretKeyForJwt123456789012345", 60000L);
    }
    
    public JwtTokenProvider(String secret, long jwtExpirationInMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.jwtExpirationInMs = jwtExpirationInMs;
    }
    
    public String generateToken(Authentication authentication, Long userId, String email, String role) {
        Date expiryDate = new Date(System.currentTimeMillis() + jwtExpirationInMs);
        
        return Jwts.builder()
            .setSubject(email)
            .claim("userId", userId)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .signWith(key)
            .compact();
    }
    
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
        
        return claims.getSubject();
    }
    
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}