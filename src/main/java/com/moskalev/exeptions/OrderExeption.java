package com.moskalev.exeptions;

public class OrderExeption extends RuntimeException{
    public OrderExeption(String message) {
        super(message);
    }
}
