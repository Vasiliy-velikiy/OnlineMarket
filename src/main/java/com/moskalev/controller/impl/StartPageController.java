package com.moskalev.controller.impl;

import com.moskalev.service.impl.SignService;
import org.springframework.web.bind.annotation.*;

/**@version 1.1
 *  * @author Vasiliy  Moskalev
 *  @since 14.02.22
 * Controller - Start page for person. This class provides interaction with Sign Up and Sign In*/


@RestController
@RequestMapping(path = "/api/startPages")
public class StartPageController {
    private final SignService signService;
    public StartPageController(SignService signService) {
        this.signService = signService;
    }


//    /**@param newPerson -Person who wants signUp in server*/
//    @PostMapping(path = "/signUp")
//    public void signUp(@RequestBody Person newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        signService.signUp(newPerson);
//
//    }
//    /**@param passwordAndEmail -person transfers already exist information about personal area*/
//@PostMapping(path = "/signIn")
//    public void sighIn( @RequestBody PasswordAndEmailDto passwordAndEmail) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        String password=passwordAndEmail.getPassword();
//        String email=passwordAndEmail.getEmail();
//        signService.signIn(email,password);
//    }
}
