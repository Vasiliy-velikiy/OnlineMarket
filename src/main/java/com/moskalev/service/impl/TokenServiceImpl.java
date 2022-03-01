package com.moskalev.service.impl;

import com.moskalev.entities.Person;
import com.moskalev.exeptions.PersonException;
import com.moskalev.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class service for generate token
 */
@Service
public class TokenServiceImpl implements TokenService {
    private final String secretKey = "secretWord";

    /**
     * @param person
     * @return token that jwt filter built
     */
    @Override
    public String generateToken(Person person) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(person.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000000000L))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    /**
     * @param token
     * @return Person name and validation
     */
    @Override
    public String extractUsernameAndValidate(String token) {
        Claims claims = Jwts.parser()       //передаем парсеру ключ  и токен и библиотека валидирует
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        if (claims == null || claims.getSubject() == null) {
            throw new PersonException("User not authorized");
        }
        return claims.getSubject();
    }
}
