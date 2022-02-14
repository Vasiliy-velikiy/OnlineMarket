package com.moskalev.controller.impl;

import com.moskalev.dto.PersonDto;

import com.moskalev.entities.Person;
import com.moskalev.service.impl.PersonService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/**
 * @version 1.1
 *  * @author Vasiliy Moskalev
 *  @since 09.02.22
 * Class controller for handling requests to persontrepository through the persontservice */

@RestController
@RequestMapping(path = "/api/person")
public class PersonController  {
private PersonService personService;

    public PersonController(com.moskalev.service.impl.PersonService personService) {
        this.personService = personService;
    }

    /**@param email -certain email that is unique
     * @return -certain product that we want to get */
    @GetMapping(path = "/read/{email}")
    public PersonDto read(@PathVariable String email) {
        return personService.read(email);
    }

    /**
     * @return list of Person*/
    @GetMapping(path="/read/all")
    public List<PersonDto> readAll() {
        return personService.readAll();
    }



    /**@param person -object that we want to create*/
    @PostMapping(path = "/create")
    public void create(@RequestBody Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.create(person);
    }


    /**@param email  -object that we want to delete*/
    @DeleteMapping(path = "/{email}")
    public void delete(@PathVariable String email) {
        personService.delete(email);

    }
    /**@param email  -certain name that is unique
     * @param newPerson-object that we want to update*/
    @PutMapping(path = "/{email}")
    public void update(@PathVariable String email, @RequestBody PersonDto newPerson) {
        personService.update(email, newPerson);
    }



}
