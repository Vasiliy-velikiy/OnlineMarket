package com.moskalev.mapper.impl;

import com.moskalev.dto.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component("toPersonDtoMapper")
public class CreatePersonToPersonDTOObjectMapper extends BaseObjectMapper<Person, PersonDto> {
    @Override
    public PersonDto convert(Person obj) {
        PersonDto personDto=new PersonDto();
        personDto.setFirstName(obj.getFirstName());
        personDto.setLastName(obj.getLastName());
        personDto.setEmail(obj.getEmail());
        return personDto;
    }

    @Override
    public Class<Person> getInClass() {
        return Person.class;
    }

    @Override
    public Class<PersonDto> getOutClass() {
        return PersonDto.class;
    }
}
