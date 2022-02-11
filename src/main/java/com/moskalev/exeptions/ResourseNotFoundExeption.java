package com.moskalev.exeptions;

public class ResourseNotFoundExeption extends  RuntimeException {

    public ResourseNotFoundExeption(String message) {
        super(message);
    }
}
