package com.spring.airline.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCountryException.class)
    public ResponseEntity<String> InvalidCountryExceptionHandler(InvalidCountryException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(InvalidNationalCodeException.class)
    public ResponseEntity<String> InvalidNationalCodeExceptionHandler(InvalidNationalCodeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<String> InvalidPhoneNumberExceptionHandler(InvalidPhoneNumberException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
