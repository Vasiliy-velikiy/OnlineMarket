package com.moskalev.controller.impl;

import com.moskalev.dto.PersonDto;

import com.moskalev.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/person")
public class PersonController  {
private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/read/{email}")
    public PersonDto read(@RequestParam String email) {
        return personService.read(email);
    }

    @GetMapping(path="/read/all")
    public List<PersonDto> readAll() {
        return personService.readAll();
    }

    @PostMapping(path = "/create")
    public void create(@RequestBody PersonDto personDto) {
        personService.create(personDto);
    }

    @DeleteMapping(path = "/{email}")
    public void delete(@PathVariable String email) {
        personService.delete(email);

    }
    @PutMapping(
            path = "/{email}"
    )
    public void update(@PathVariable String email, @RequestBody PersonDto newPerson) {
        personService.update(email, newPerson);
    }





}
