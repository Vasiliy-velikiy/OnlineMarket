package com.moskalev.service;

import com.moskalev.dto.Impl.PersonDto;
import com.moskalev.entities.Person;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 04.02.22
 * Class interface for PersonServiceImpl
 */
public interface PersonService<T> {
    /**
     * @return page of all Person in table person. We used initialize() for fetch List
     */
    Page<T> readAll();

    /**
     * @param email certain email that is unique
     * @return certain Person by email
     */
    Person read(String email);

    /**
     * @param newPersonDto -class of Person.
     */
    void create(PersonDto newPersonDto) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * @param id -certain email
     */
    void delete(Integer id);

    /**
     * @param id        -certain email
     * @param newPerson -new Person that we want to put in database
     */
    public void update(Integer id, PersonDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
