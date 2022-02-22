package com.moskalev.service.impl;

import com.moskalev.dto.Impl.PersonToCreateDto;
import com.moskalev.dto.Impl.PersonToUpdateDto;
import com.moskalev.entities.Person;
import com.moskalev.exeptions.PersonException;
import com.moskalev.mapper.PersMapper;
import com.moskalev.repositories.PersonRepository;
import com.moskalev.service.PersonService;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 04.02.22
 * Class service for person which provides interaction with personRepository
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    /**
     * filed describes object for convert
     */
    private final PersMapper objectMapper;

    /**
     * filed describes object for encoding
     */
    private final PasswordEncryptionService passwordEncryptionService;
    private static final String saltForEncryptingPassword = "mySalt";


    public PersonServiceImpl(PersonRepository personRepository, PersMapper objectMapper, PasswordEncryptionService passwordEncryptionService) {
        this.personRepository = personRepository;
        this.objectMapper = objectMapper;
        this.passwordEncryptionService = passwordEncryptionService;
    }

    /**
     * @return page of all Person in table person. We used initialize() for fetch List
     */
    public Page<Person> readAll() {
        List<Person> listPersons = personRepository.findAll();
        for (Person personOptional : listPersons) {
            Hibernate.initialize(personOptional);
            Hibernate.initialize(personOptional.getBasketForProductList());
        }
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return new PageImpl<>(listPersons, firstPageWithTwoElements, listPersons.size());
    }

    /**
     * @param email certain email that is unique
     * @return certain Person by email
     * @throws PersonException if  User not found
     *                         initialize()-method for fetch List
     */
    public Person read(String email) {
        Optional<Person> personOptional = personRepository.findByEmail(email);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            Hibernate.initialize(person);
            Hibernate.initialize(person.getBasketForProductList());
            return person;
        } else {
            throw new PersonException(String.format("User with email %s not found", email));
        }
    }

    /**
     * @param newPersonToCreateDto -class of Person.
     * @throws PersonException if User already exists
     *                         else-create new User. We encrypt passing password and set new password to Database
     */
    public void create(PersonToCreateDto newPersonToCreateDto) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Optional<Person> templatePerson = personRepository.findByEmail(newPersonToCreateDto.getEmail());
        if (!templatePerson.isPresent()) {
            newPersonToCreateDto.setPassword(passwordEncryptionService.hashToHex(newPersonToCreateDto.getPassword(), Optional.of(saltForEncryptingPassword)));
            Person newPerson = objectMapper.fromDto(newPersonToCreateDto);
            personRepository.save(newPerson);
        } else {
            throw new PersonException(String.format("User with email %s already exists", newPersonToCreateDto.getEmail()));
        }
    }

    /**
     * @param id -certain email
     * @throws PersonException if  Person not found
     */
    public void delete(Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            personRepository.delete(person);
        } else {
            throw new PersonException("Person not found");
        }
    }

    /**
     * @param id        -certain email
     * @param newPerson -new Person that we want to put in database
     * @throws PersonException if Person not found
     */
    public void update(Integer id, PersonToUpdateDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person target = optionalPerson.get();
            Person source = objectMapper.fromUpdateDto(newPerson);
            if (source.getPassword() != null) {
                source.setPassword(passwordEncryptionService.hashToHex(source.getPassword(), Optional.of(saltForEncryptingPassword)));
            }
            personRepository.save(objectMapper.merge(target, source));
        } else {
            throw new PersonException("Person not found");
        }
    }
}
