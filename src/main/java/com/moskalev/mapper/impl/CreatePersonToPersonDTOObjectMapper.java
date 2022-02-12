package com.moskalev.mapper.impl;

import com.moskalev.dto.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;
/**@version  1.1
 * @author Vasiliy Moskalev
 * This class converts Person class to PersonDto*/
@Component("toPersonDtoMapper")
public class CreatePersonToPersonDTOObjectMapper extends BaseObjectMapper<Person, PersonDto> {


    /**@param obj-Person class
     * @return  same Dto class*/
    @Override
    public PersonDto convert(Person obj) {
        PersonDto personDto=new PersonDto();
        personDto.setFirstName(obj.getFirstName());
        personDto.setLastName(obj.getLastName());
        personDto.setEmail(obj.getEmail());
        return personDto;
    }


    /**@return name inner class*/
    @Override
    public Class<Person> getInClass() {
        return Person.class;
    }

    /**@return name outer class*/
    @Override
    public Class<PersonDto> getOutClass() {
        return PersonDto.class;
    }
}
