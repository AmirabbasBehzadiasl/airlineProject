package com.spring.airline.Exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
