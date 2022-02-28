package com.moskalev.service.impl;

import com.moskalev.dto.personDto.PersonSignInDto;
import com.moskalev.dto.personDto.PersonToCreateDto;
import com.moskalev.entities.Person;
import com.moskalev.exeptions.PersonException;
import com.moskalev.repositories.PersonRepository;
import com.moskalev.service.PersonService;
import com.moskalev.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl {

    private final PersonService personService;

    private final TokenService tokenService;

    private final PasswordEncryptionService passwordEncryptionService;

    private final PersonRepository personRepository;


    //не секьюриться так как сайнапиться кто угодно
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
     * @param personSignInDto  -already existing person
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
