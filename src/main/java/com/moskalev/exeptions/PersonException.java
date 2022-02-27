package com.moskalev.exeptions;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 21.02.22
 * Class runtime exception if  User not found or already exists
 */
public class PersonException extends RuntimeException {
    public PersonException(String message) {
        super(message);
    }

}
