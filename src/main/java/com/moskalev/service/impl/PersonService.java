package com.moskalev.service.impl;

import com.moskalev.dto.PersonDto;
import com.moskalev.entities.Person;
import com.moskalev.exeptions.ResourseNotFoundExeption;
import com.moskalev.mapper.ObjectMapper;
import com.moskalev.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

/**@version  1.1
 *  @author Vasiliy Moskalev
 * @since 04.02.22
 * Class service for person which provides interaction with personRepository  */
@Service
public class PersonService  {
    private final PersonRepository personRepository;
    private final ObjectMapper<Person,PersonDto> objectMapper;

    /**filed describes object for convert*/
    private final ObjectMapper<PersonDto,Person> personDtoMapper;


    public PersonService(PersonRepository personRepository, @Qualifier("toPersonDtoMapper") ObjectMapper<Person,PersonDto> objectMapper, @Qualifier("toPersonMapper")ObjectMapper<PersonDto,Person> personDtoMapper) {
        this.personRepository = personRepository;
        this.objectMapper = objectMapper;
        this.personDtoMapper=personDtoMapper;
    }


   /**@return list of all Person in table person*/
    public List<PersonDto> readAll() {
     List<Person> listPersons= personRepository.findAll();
     return  objectMapper.convertList(listPersons);

    }

    /**@param email certain email that is unique
     * @return certain Person by email
     * @throws ResourseNotFoundExeption if  User not found*/
    public PersonDto read(String email) {
     Optional<Person>personOptional = personRepository.findByEmail(email);

     if(personOptional.isPresent()){
         return objectMapper.convert(personOptional.get());
     }
       throw new ResourseNotFoundExeption(String.format("User with email %s not found",email));
    }


    /**@param o class of Person
     *  @throws ResourseNotFoundExeption if User already exists
     *  else-create new User  */
    public void create(Person o) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Person person=o;
        Optional<Person> personOptional=personRepository.findByEmail(o.getEmail());
        if(!personOptional.isPresent()) { //
            PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
            person.setPassword(passwordEncryptionService.hashToHex(person.getPassword(), Optional.of("mysolt")));
            personRepository.save(person);
        }
        else throw  new ResourseNotFoundExeption(String.format("User with email %s already exists",o.getEmail()));
    }

      /**@param o -certain email
       *  @throws ResourseNotFoundExeption if  User not found*/
    public void delete(String o) {

       Optional <Person> optionalPerson=personRepository.findByEmail(o);
       if(optionalPerson.isPresent()){
          Person person= optionalPerson.get();
          personRepository.delete(person);
       } else { throw new ResourseNotFoundExeption("User not found");
       }
    }

  /**@param email -certain email
   * @param newPerson -new Person that we want to put in database
   * @throws ResourseNotFoundExeption if Person not found*/
    public void update(String email, PersonDto newPerson) {
        Optional<Person> optionalPerson = personRepository.findByEmail(email);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setEmail(newPerson.getEmail());
            person.setFirstName(newPerson.getFirstName());
            person.setLastName(newPerson.getLastName());
            personRepository.saveAndFlush(person);
        }
        else throw new ResourseNotFoundExeption("Person not found");
    }
}
