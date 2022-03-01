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

@Service
public class TokenServiceImpl implements TokenService {
//    private final String secretKey = "secretWord";
////токен состоит из 3хчастей 1-заголовок( в нем указывается с помощую чего он подписывается
//  //  2часть-тело токена-содержит атрибуты текущего пользователя Subject
//    //3часть-подпись-она приватна. У генерации токена есть правило, при получении его можго задекодить
////setClaims-данные пользователя(боди)
//    //setSubject-юзернейм пользователя
////setIssuedAt-дата создания
//    //setExpiration-дата прекращения действия
//    //signWith(SignatureAlgorithm.ES256)-подпись токена с секретным словом-защита если токен был украден
//    @Override
//    public String generateToken(Person person) {
//        return Jwts.builder()
//                .setClaims(new HashMap<>())
//                .setSubject(person.getEmail())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+1000000000L))
//                .signWith(SignatureAlgorithm.HS512,secretKey)
//                .compact();
//    }
//
//    @Override
//    public String extractUsernameAndValidate(String token) {
//        Claims claims = Jwts.parser()       //передаем парсеру ключ  и токен и библиотека валидирует
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody();
//        if (claims == null || claims.getSubject() == null) {
//            throw new PersonException("User not authorized");
//        }
//        return claims.getSubject();
//    }
}
