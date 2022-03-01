package com.moskalev.mapper.impl;

import com.moskalev.dto.personDto.PersonDto;
import com.moskalev.dto.personDto.PersonToCreateDto;
import com.moskalev.entities.Person;
import com.moskalev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Person to PersonDto and PersonToCreateDto and back
 */
@Component
@RequiredArgsConstructor
public class PersonMapper implements Mapper<Person, PersonDto> {

    /**
     * @param source -Person  object
     * @return PersonDto object
     */
    @Override
    public PersonDto toDto(Person source) {
        PersonDto personDto=new PersonDto();
        personDto.setEmail(source.getEmail());
        personDto.setFirstName(source.getFirstName());
        personDto.setLastName(source.getLastName());
        personDto.setPassword(source.getPassword());
        personDto.setRole(source.getRole());
        if(source.getOrders().size()!=0){
            List<Integer>numberOfOrders=new ArrayList<>();
            for (int i = 0; i <source.getOrders().size() ; i++) {
                Integer number=source.getOrders().get(i).getId();
                numberOfOrders.add(number);
            }
            personDto.setNumberOfOrders(numberOfOrders);
        }
        return personDto;
    }

    /**
     * @param source -PersonDto  object
     * @return Person object
     */
    @Override
    public Person fromDto(PersonDto source) {
        Person person=new Person();
        person.setEmail(source.getEmail());
        person.setFirstName(source.getFirstName());
        person.setLastName(source.getLastName());
        person.setPassword(source.getPassword());
        person.setRole(source.getRole());
        return person;
    }

    /**
     * @param source -PersonToCreateDto object
     * @return Person object
     */
    public Person fromCreateDto(PersonToCreateDto source) {
        Person person=new Person();
        person.setEmail(source.getEmail());
        person.setFirstName(source.getFirstName());
        person.setLastName(source.getLastName());
        person.setPassword(source.getPassword());
        person.setRole(source.getRole());
        return person;
    }

    /**
     * @param objList - list of Person object
     * @return PersonDto list
     */
    @Override
    public List<PersonDto> convertListToDto(List<Person> objList) {
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : objList) {
            personDtoList.add(toDto(person));
        }
        return personDtoList;
    }
}
