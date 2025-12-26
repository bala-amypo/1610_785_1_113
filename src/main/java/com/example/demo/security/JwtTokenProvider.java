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

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    private final String jwtSecret = "testSecretKey123456testSecretKey123456";
    private final long jwtExpirationMs = 86400000;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // ✅ REQUIRED BY TEST CASES
    public String generateToken(Authentication authentication) {

        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ REQUIRED BY JwtAuthenticationFilter
    public String getUsernameFromToken(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()                    // 🔥 THIS WAS MISSING
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // ✅ REQUIRED BY JwtAuthenticationFilter
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()                // 🔥 THIS WAS MISSING
                .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
