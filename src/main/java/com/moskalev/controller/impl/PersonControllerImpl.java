package com.moskalev.controller.impl;


import com.moskalev.controller.PersonController;
import com.moskalev.dto.personDto.PersonDto;
import com.moskalev.dto.personDto.PersonToCreateDto;
import com.moskalev.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Tag(name = "Person", description = "this is person controller")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "User not found")
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;

    public PersonControllerImpl(PersonService personService) {
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
    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')" )
    public PersonDto read(@RequestParam(name = "email") String email) {
        return personService.read(email);
    }

    /**
     * @return page of Persons
     */
    @Operation(description = "Find all users")
    @ApiResponse(responseCode = "200", description = "All Users successfully found")
    @ApiResponse(responseCode = "500", description = "Users not found")
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')" )
    public Page<PersonDto> readAll() {
        return personService.readAll();
    }

    /**
     * @param person -object that we want to create
     */
    @Operation(description = "Create user")
    @ApiResponse(responseCode = "200", description = "User successfully created")
    @ApiResponse(responseCode = "500", description = "User already exists")
    @PostMapping
    @PreAuthorize("hasRole('CUSTOMER') || hasAuthority('ROLE_CUSTOMER') || hasRole('ADMIN') || hasAuthority('ROLE_ADMIN') || hasRole('EMPLOYEE') || hasAuthority('ROLE_EMPLOYEE')" )
    public void create(@Valid @RequestBody PersonToCreateDto person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.create(person);
    }

    /**
     * @param id -object that we want to delete
     */
    @Operation(description = "Delete user by id")
    @ApiResponse(responseCode = "204", description = "User successfully deleted")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')" )
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }

    /**
     * @param id               -certain name that is unique
     * @param newPerson-object that we want to update
     */
    @Operation(description = "Update user")
    @ApiResponse(responseCode = "200", description = "User successfully updated")
    @PatchMapping(path = "/{id}")
    @PreAuthorize("hasRole('CUSTOMER') || hasAuthority('ROLE_CUSTOMER') || hasRole('ADMIN') || hasAuthority('ROLE_ADMIN') || hasRole('EMPLOYEE') || hasAuthority('ROLE_EMPLOYEE')" )
    public void update(@PathVariable Integer id, @RequestBody PersonDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.update(id, newPerson);
    }
}
