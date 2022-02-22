package com.moskalev.controller.impl;


import com.moskalev.dto.Impl.PersonToCreateDto;
import com.moskalev.dto.Impl.PersonToUpdateDto;
import com.moskalev.entities.Person;
import com.moskalev.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 09.02.22
 * Class controller for handling requests to personRepository through the personService
 */
@RestController
@RequestMapping(path = "/api/persons")
@Tag(name = "Person", description = "this is short description")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "User not found")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * @param email -certain email that is unique
     * @return -certain product that we want to get
     */
    @Operation(description = "Find user by email")
    @ApiResponse(responseCode = "200", description = "User successfully found")
    @ApiResponse(responseCode = "500", description = "User not found")
    @GetMapping(path = "/email")
    public Person read(@RequestParam(name = "email") String email) {
        return personService.read(email);
    }

    /**
     * @return page of Persons
     */
    @Operation(description = "Find all users")
    @ApiResponse(responseCode = "200", description = "All Users successfully found")
    @GetMapping
    public Page<Person> readAll() {
        return personService.readAll();
    }


    /**
     * @param person -object that we want to create
     */
    @Operation(description = "Create user")
    @ApiResponse(responseCode = "200", description = "User successfully created")
    @PostMapping
    public void create(@Valid @RequestBody PersonToCreateDto person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.create(person);
    }

    /**
     * @param id -object that we want to delete
     */
    @Operation(description = "Delete user by email")
    @ApiResponse(responseCode = "204", description = "User successfully deleted")
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }

    /**
     * @param id -certain name that is unique
     * @param newPerson-object that we want to update
     */
    @Operation(description = "Update user")
    @ApiResponse(responseCode = "200", description = "User successfully updated")
    @PatchMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody PersonToUpdateDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.update(id, newPerson);
    }
}
