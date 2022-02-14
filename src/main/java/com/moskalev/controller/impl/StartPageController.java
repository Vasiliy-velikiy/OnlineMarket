package com.moskalev.controller.impl;

import com.moskalev.dto.PasswordDto;
import com.moskalev.entities.Person;
import com.moskalev.service.SignService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**Controller - Start page for person. This class provides interaction with Sign Up and Sign In*/


@RestController
@RequestMapping(path = "/api/startPage")
public class StartPageController {
    private SignService signService;
    public StartPageController(SignService signService) {
        this.signService = signService;
    }



    @PostMapping(path = "/signUp")
    public void signUp(@RequestBody Person newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        signService.signUp(newPerson);

    }

    /*@PostMapping(path = "/signIn/{email}")
    public void sighIn(@PathVariable String email, @RequestBody PasswordDto passwordDto) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("password befor encoding");
        System.out.println(passwordDto.getPassword());
        signService.signIn(email,passwordDto.getPassword());

    }*/

@PostMapping(path = "/signIn/{email}")
    public void sighIn(@PathVariable String email, @RequestBody String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("password befor encoding");
        System.out.println(password);
        signService.signIn(email,password);

    }
}
