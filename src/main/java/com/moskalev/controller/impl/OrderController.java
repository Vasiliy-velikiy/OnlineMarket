package com.moskalev.controller.impl;

import com.moskalev.dto.Impl.PersonToCreateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class controller for handling requests to personRepository through the personService
 */
@RestController
@RequestMapping(path = "/api/orders")
public class OrderController {




//    @PostMapping
//    public void createOrder(@Valid @RequestBody ) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        personService.create(person);
//    }
}
