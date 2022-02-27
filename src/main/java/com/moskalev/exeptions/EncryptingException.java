package com.moskalev.exeptions;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 21.02.22
 * Class runtime exception if  Encrypting have some problems
 */
public class EncryptingException extends RuntimeException {
    public EncryptingException(String message) {
        super(message);
    }
}
