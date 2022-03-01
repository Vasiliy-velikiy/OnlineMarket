package com.moskalev.controller;


import com.moskalev.dto.personDto.PersonDto;
import com.moskalev.dto.personDto.PersonToCreateDto;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 09.02.22
 * interface controller for person controller
 */
public interface PersonController<Person> {

    /**
     * @param email -certain email that is unique
     * @return -certain product that we want to get
     */
    PersonDto read(String email);

    /**
     * @return page of Persons
     */
    Page<PersonDto> readAll();

    /**
     * @param person -object that we want to create
     */
    void create(PersonToCreateDto person) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * @param id -object that we want to delete
     */
    void delete(Integer id);

    /**
     * @param id               -certain name that is unique
     * @param newPerson-object that we want to update
     */
    void update(Integer id, PersonDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException;

}
