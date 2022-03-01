package com.moskalev.service;

import com.moskalev.entities.Person;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.03.22
 * Class service for generate token
 */
public interface TokenService {

    String generateToken(Person person);

    String extractUsernameAndValidate(String token);
}
