package com.moskalev.exeptions;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 21.02.22
 * Class runtime exception if  Provider not found or already exists
 */
public class ProviderException extends RuntimeException {
    public ProviderException(String message) {
        super(message);
    }
}