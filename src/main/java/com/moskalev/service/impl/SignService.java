package com.moskalev.service.impl;

import com.moskalev.repositories.PersonRepository;

import org.springframework.stereotype.Service;

/**@version  1.1
 *  @author Vasiliy Moskalev
 * @since 14.02.22
 * Class service  for create New person This class calls create method from PersonService */
@Service
public class SignService  {
  private final PersonServiceImpl personServiceImpl;
  private final PersonRepository personRepository;

    public SignService(PersonServiceImpl personServiceImpl, PersonRepository personRepository) {
        this.personServiceImpl = personServiceImpl;
        this.personRepository = personRepository;
    }
//
//    /**@param newPerson -new Person who wants Sign Up in service
// * call to method create in personService*/
//    public void signUp(Person newPerson) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        personService.create(newPerson);
//    }
//
//    /**@param email -already existing email
//     * @param password -already existing password
//     * @throws  ResourseNotFoundExeption if Wrong password
//     * @throws ResourseNotFoundExeption if User with email not exists*/
//    public void signIn(String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        Optional<Person>optionalPerson=personRepository.findByEmail(email);
//        if(optionalPerson.isPresent()){
//            Person person=optionalPerson.get();
//            PasswordEncryptionService passwordEncryptionService =new PasswordEncryptionService();
//            String encryptionPassword= passwordEncryptionService.hashToHex(password, Optional.of("mysolt"));//transmitted password is encrypted
//            if(!person.getPassword().equals(encryptionPassword)){//encrypted password compared with password in database
//                throw  new ResourseNotFoundExeption(String.format("Wrong password, please try again"));
//            }
//        }
//        else throw  new ResourseNotFoundExeption(String.format("User with email %s not found",email));
//    }
}
