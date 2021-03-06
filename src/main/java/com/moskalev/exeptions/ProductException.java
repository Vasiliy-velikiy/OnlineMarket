package com.moskalev.exeptions;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 21.02.22
 * Class runtime exception if  Product not found or already exists
 */
public class ProductException extends RuntimeException {
    public ProductException(String message) {
        super(message);
    }

}