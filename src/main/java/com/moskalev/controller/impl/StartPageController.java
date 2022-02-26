package com.moskalev.controller.impl;


import com.moskalev.dto.personDto.PersonSignInDto;
import com.moskalev.dto.personDto.PersonToCreateDto;
import com.moskalev.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @version 1.1
 * * @author Vasiliy Moskalev
 * @since 14.02.22
 * Controller - Start page for person. This class provides interaction with Sign Up and Sign In
 */
@RestController
@RequestMapping(path = "/api/startPages")
public class StartPageController {
    private final PersonService personService;

    public StartPageController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * @param newPerson -Person who wants signUp in server
     */
    @PostMapping(path = "/signUp")
    public void signUp(@RequestBody PersonToCreateDto newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.create(newPerson);
    }

    /**
     * @param personSignInDto -person transfers already exist information about personal area
     */
    @PostMapping(path = "/signIn")
    public void sighIn(@RequestBody PersonSignInDto personSignInDto) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        personService.signIn(personSignInDto.getEmail(), personSignInDto.getPassword());
    }
}
