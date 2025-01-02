package com.a99.security;

import com.a99.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private String secretKey = System.getenv("JWT_SECRET_KEY");  // Use environment variables for security

    // Get username from JWT token
    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            // Handle invalid token or parse errors
            return null;
        }
    }

    // Validate the JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException |
                 UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println("JWT error: " + e.getMessage());
            return false;
        }
    }

    // Generate JWT token
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // Expiration time: 1 hour
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
