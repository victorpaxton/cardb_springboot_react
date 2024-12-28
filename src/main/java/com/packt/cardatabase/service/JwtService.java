package com.packt.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    static final long EXPIRATIONTIME = 86400000; // 1 day in milliseconds

    static final String PREFIX = "Bearer";

    // Generate secret key. Only for demonstration purposes.
    // In production, you should read it from the application
    // configuration.
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Generate a signed JWT token
    public String getToken(String username) {

        return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(key).compact();
    }

    // Get a token from request Authorization header,
    // verify the token, and get username
    public String getAuthUser(HttpServletRequest request) {

            String token = request.getHeader("Authorization");

            if (token != null) {
                String user = Jwts.parserBuilder().setSigningKey(key).build()
                        .parseClaimsJws(token.replace(PREFIX, ""))
                        .getBody().getSubject();

                return user;
            }

            return null;
    }
}
