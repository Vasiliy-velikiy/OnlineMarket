package com.moskalev.exeptions;
/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 21.02.22
 * Class runtime exception if  User not found or already exists */
public class PersonException extends  RuntimeException {
    public PersonException(String message) {
        super(message);
    }

}
