package com.moskalev.exeptions;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 21.02.22
 * Class runtime exception if Orders has some problems
 */
public class OrderExeption extends RuntimeException{
    public OrderExeption(String message) {
        super(message);
    }
}
