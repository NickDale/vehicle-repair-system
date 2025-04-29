package com.Vehicle_Repair_System_BackEnd.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration:100}")
    private long expiration;



    public String generateToken(final String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(final String token) {
        try {
            final Claims claims = this.claimsFromToken(token);
            final Date expiration = claims.getExpiration();

            if (expiration.before(new Date())) {
                throw new RuntimeException("Token is invalid");
            }
            return claims.getSubject();
        } catch (JwtException ex) {
            throw new RuntimeException("Token is invalid", ex);
        }
    }

//    private boolean isTokenExpired(String token) {
//        try {
//            final Claims claims = this.claimsFromToken(token);
//            final Date expiration = claims.getExpiration();
//            if (expiration.before(new Date())) {
//                return false;
//            }
//            return true;
//        } catch (JwtException ex) {
//            throw new RuntimeException("Token is invalid", ex);
//        }
//        return expiration.before(new Date());
//    }

    private Claims claimsFromToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
