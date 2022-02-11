package com.moskalev.mapper.impl;

import com.moskalev.dto.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component("toPersonMapper")
public class CreatePersonDTOToPersonObjectMapper extends BaseObjectMapper<PersonDto, Person> {
    @Override
    public Person convert(PersonDto obj) {
       Person person=new Person();
       person.setFirstName(obj.getFirstName());
       person.setLastName(obj.getLastName());
       person.setEmail(obj.getEmail());
        return person;
    }

    @Override
    public Class<PersonDto> getInClass() {
        return PersonDto.class;
    }

    @Override
    public Class<Person> getOutClass() {
        return Person.class;
    }
}
