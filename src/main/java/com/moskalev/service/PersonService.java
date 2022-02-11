package com.moskalev.service;

import com.moskalev.dto.PersonDto;
import com.moskalev.entities.Person;

import com.moskalev.exeptions.ResourseNotFoundExeption;
import com.moskalev.mapper.ObjectMapper;
import com.moskalev.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final ObjectMapper<Person,PersonDto> objectMapper;
    private final ObjectMapper<PersonDto,Person> personDtoMapper;


    public PersonService(PersonRepository personRepository, @Qualifier("toPersonDtoMapper") ObjectMapper<Person,PersonDto> objectMapper,@Qualifier("toPersonMapper")ObjectMapper<PersonDto,Person> personDtoMapper) {
        this.personRepository = personRepository;
        this.objectMapper = objectMapper;
        this.personDtoMapper=personDtoMapper;
    }



    public List<PersonDto> readAll() {
     List<Person> listPersons= personRepository.findAll();
     return  objectMapper.convertList(listPersons);

    }


    public PersonDto read(String email) {
     Optional<Person>personOptional = personRepository.findByEmail(email);

     if(personOptional.isPresent()){
         return objectMapper.convert(personOptional.get());
     }
       throw new ResourseNotFoundExeption(String.format("User with email %s nit found",email));
    }


    public void create(PersonDto o) {
      Person person=  personDtoMapper.convert(o);
      personRepository.save(person);

    }


    public void delete(String o) {
        personRepository.deleteByEmail(o);

    }


    public void update(PersonDto o, PersonDto newT) {
    //  Person person=  personRepository.findById((Integer)o);
        Map<Integer, Person> content= (Map<Integer, Person>) personRepository.findAll();


    }
}
