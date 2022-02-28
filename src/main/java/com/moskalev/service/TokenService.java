package com.moskalev.service;

import com.moskalev.entities.Person;

public interface TokenService {
    String generateToken(Person person);
    //метод на извлечение имени пользователя и проверки, валдиный он или нет
    String extractUsernameAndValidate(String token);
}
