package com.neikiskill.system_skills.config;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        String token = Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
            .compact();
        
        return token;
    }

    public String getUsernameFromJwt(String token){
        Claims claims = Jwts.parser()
                        .setSigningKey(SecurityConstants.JWT_SECRET)
                        .parseClaimsJws(token)
                        .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        // System.out.println(token);
        try {
            Jwts.parser()
                        .setSigningKey(SecurityConstants.JWT_SECRET)
                        .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Falha em JWT." + e.getMessage());
        }
    }
}
