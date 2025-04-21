package com.spring.airline.Exceptions;

public class InvalidNationalCodeException extends RuntimeException {
    public InvalidNationalCodeException(String message) {
        super(message);
    }
}
