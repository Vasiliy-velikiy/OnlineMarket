package com.moskalev.controller.impl;

import com.moskalev.controller.CrudController;
import com.moskalev.dto.PersonDto;

import com.moskalev.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api/person")
public class PersonController implements CrudController<PersonDto> {
private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/read/{email}")
    @Override
    public PersonDto read(@RequestParam String email) {
        return personService.read(email);
    }

    @GetMapping(path="/read/all")
    @Override
    public List<PersonDto> readAll() {
        return personService.readAll();
    }

    @GetMapping(path = "/create/{person}")
    @Override
    public void create(@RequestParam PersonDto personDto) {
        personService.create(personDto);
    }

    @GetMapping(path = "/delete/{person}")
    @Override
    public void delete(@RequestParam PersonDto personDto) {
        personService.delete(personDto);

    }

    @Override
    public void update(PersonDto personDto, PersonDto newT) {

    }





}
