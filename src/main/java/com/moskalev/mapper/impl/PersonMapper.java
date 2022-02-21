package com.moskalev.mapper.impl;

import com.moskalev.dto.Impl.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.mapper.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 08.02.22
 * This class converts PersonDto class to Person and back
 */
@Component("PersonMapper")
@AllArgsConstructor(access = PRIVATE)
public class PersonMapper implements ObjectMapper<Person, PersonDto> {
    /**
     * @param obj-Person class
     * @return same Dto class
     */
    @Override
    public PersonDto convertToDto(Person obj) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(obj.getFirstName());
        personDto.setLastName(obj.getLastName());
        personDto.setEmail(obj.getEmail());
        personDto.setPassword(obj.getPassword());
        personDto.setRole(obj.getRole());
        return personDto;
    }

    /**
     * @param obj -PersonDto class
     * @return same Person class
     */
    @Override
    public Person convertFromDto(PersonDto obj) {
        Person person = new Person();
        person.setFirstName(obj.getFirstName());
        person.setLastName(obj.getLastName());
        person.setEmail(obj.getEmail());
        person.setPassword(obj.getPassword());
        person.setRole(obj.getRole());
        return person;
    }
}
