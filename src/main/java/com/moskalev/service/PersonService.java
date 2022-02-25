package com.moskalev.service;

import com.moskalev.dto.Impl.PersonToCreateDto;
import com.moskalev.dto.Impl.PersonToUpdateDto;
import com.moskalev.entities.Person;
import com.moskalev.exeptions.PersonException;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 04.02.22
 * Class interface for PersonServiceImpl
 */
public interface PersonService {

    /**
     * @return page of all Person in table person. We used initialize() for fetch List
     */
    Page<Person> readAll();

    /**
     * @param email certain email that is unique
     * @return certain Person by email
     */
    Person read(String email);

    /**
     * @param newPersonToCreateDto -class of Person.
     */
    void create(PersonToCreateDto newPersonToCreateDto) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * @param id -certain email
     */
    void delete(Integer id);

    /**
     * @param id        -certain email
     * @param newPerson -new Person that we want to put in database
     */
     void update(Integer id, PersonToUpdateDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * @param email    -already existing email
     * @param password -already existing password
     */
     void signIn(String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
