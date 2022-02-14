package com.moskalev.mapper.impl;

import com.moskalev.dto.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 08.02.22
 * This class converts PersonDto class to Person*/

@Component("toPersonMapper")
public class CreatePersonDTOToPersonObjectMapper extends BaseObjectMapper<PersonDto, Person> {

    /**@param obj -PersonDto class
     * @return  same Person class*/
    @Override
    public Person convert(PersonDto obj) {
       Person person=new Person();
       person.setFirstName(obj.getFirstName());
       person.setLastName(obj.getLastName());
       person.setEmail(obj.getEmail());
        return person;
    }
     /**@return name inner class*/
    @Override
    public Class<PersonDto> getInClass() {
        return PersonDto.class;
    }

    /**@return name outer class*/
    @Override
    public Class<Person> getOutClass() {
        return Person.class;
    }
}
