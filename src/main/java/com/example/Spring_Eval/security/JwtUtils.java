package com.example.Spring_Eval.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {


    public String getEmailFromJwt(String jwt) {

        return Jwts.parser()
                .setSigningKey("azerty")
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();


    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .signWith(
                        SignatureAlgorithm.HS256,
                        "azerty")
                .compact();
    }
}
