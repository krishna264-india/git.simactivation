package com.telecom.simactivation.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    // 🔐 Secret key (minimum 32 chars for HS256)
    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey8008";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // ⏳ Token validity (1 hour)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    // Generate token
    public String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    // ✅ Extract Username
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ Validate Token
    public boolean validateToken(String token) {
        try {
            getClaims(token); // will throw exception if invalid
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 🔍 Extract Claims
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
