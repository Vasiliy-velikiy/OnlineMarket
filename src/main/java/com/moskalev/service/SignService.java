package com.moskalev.service;

import com.moskalev.entities.Person;
import com.moskalev.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**Class service  for create New person This class calls create method from PersonService */
@Service
public class SignService {
  private PersonService personService;
  private PersonRepository personRepository;

    public SignService(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    /**@param newPerson -new Person who wants Sign Up in service
 * call to method create in personService*/
    public void signUp(Person newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.create(newPerson);
    }

    public void signIn(String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        PasswordEncryptionService passwordEncryptionService=new PasswordEncryptionService();
        String encryptionPassword=passwordEncryptionService.hashToHex(password, Optional.of("mysolt"));
        System.out.println(encryptionPassword);


    }

}
