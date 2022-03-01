package com.moskalev.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import com.moskalev.dto.personDto.PersonSignInDto;
import com.moskalev.dto.personDto.PersonToCreateDto;
import com.moskalev.entities.Person;
import com.moskalev.exeptions.PersonException;
import com.moskalev.repositories.PersonRepository;
import com.moskalev.service.PersonService;
import com.moskalev.service.TokenService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class service for singUp and signIn
 */
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl {

    private final PersonService personService;

    private final TokenService tokenService;

    private final PasswordEncryptionService passwordEncryptionService;

    private final PersonRepository personRepository;


    /**
     * @param newPerson -new Person
     * @return token for access
     */
    public String signUp(PersonToCreateDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Person person = new Person();
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setEmail(newPerson.getEmail());
        person.setRole(newPerson.getRole());
        person.setPassword(passwordEncryptionService.hashToHex(newPerson.getPassword(), Optional.of("mySalt")));
        personService.create(newPerson);
        return tokenService.generateToken(person);
    }

    /**
     * @param personSignInDto -person that already exists in DB
     * @return token for access
     * @throws PersonException if Errors with token password
     * @throws PersonException if User not found
     */
    public String sighIn(PersonSignInDto personSignInDto) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Optional<Person> personOptional = personRepository.findByEmail(personSignInDto.getEmail());
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            if (passwordEncryptionService.hashToHex(personSignInDto.getPassword(), Optional.of("mySalt")).equals(person.getPassword())) {
                return tokenService.generateToken(person);
            } else {
                throw new PersonException("Password is wrong, please try again");
            }
        } else {
            throw new PersonException("User not found");
        }
    }
}
