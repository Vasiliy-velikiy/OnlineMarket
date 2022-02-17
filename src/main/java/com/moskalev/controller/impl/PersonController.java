package com.moskalev.controller.impl;

import com.moskalev.dto.PersonDto;

import com.moskalev.entities.Person;
import com.moskalev.service.impl.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/**
 * @version 1.1
 * @author Vasiliy Moskalev
 *  @since 09.02.22
 * Class controller for handling requests to persontrepository through the persontservice */

@RestController
@RequestMapping(path = "/api/persons")
@Tag(name="Person",description = "this is short description")
@ApiResponse(responseCode = "500",description = "Internal error")
@ApiResponse(responseCode = "400",description = "Validation failed")
@ApiResponse(responseCode = "404",description = "User not found")
public class PersonController  {
private PersonService personService;

    public PersonController(com.moskalev.service.impl.PersonService personService) {
        this.personService = personService;
    }


    /**@param email -certain email that is unique
     * @return -certain product that we want to get */
    @Operation(description = "Find user by email")
    @ApiResponse(responseCode = "200",description = "User successfully found")
    @ApiResponse(responseCode = "500",description = "User not found")
    @GetMapping(path = "/read/{email}")
    public PersonDto read(@PathVariable String email) {
        return personService.read(email);
    }

    /**
     * @return list of Person*/
    @Operation(description = "Find all users")
    @ApiResponse(responseCode = "200",description = "All Users successfully found")
    @GetMapping(path="/read/all")
    public List<PersonDto> readAll() {
        return personService.readAll();
    }



    /**@param person -object that we want to create*/
    @Operation(description = "Create user")
    @ApiResponse(responseCode = "200",description = "User successfully created")
    @PostMapping(path = "/create")
    public void create(@Valid @RequestBody Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.create(person);
    }


    /**@param email  -object that we want to delete*/
    @Operation(description = "Delete user by email")
    @ApiResponse(responseCode = "204",description = "User successfully deleted")
    @DeleteMapping(path = "/{email}")
    public void delete(@PathVariable String email) {
        personService.delete(email);

    }
    /**@param email  -certain name that is unique
     * @param newPerson-object that we want to update*/
    @Operation(description = "Update user")
    @ApiResponse(responseCode = "200",description = "User successfully updated")
    @PutMapping(path = "/{email}")
    public void update(@PathVariable String email, @RequestBody PersonDto newPerson) {
        personService.update(email, newPerson);
    }

}
