package com.spring.airline.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import validation.ValidNationalCode;
import validation.ValidPhoneNumber;

public class UserCreateDto {

    @Valid
    @NotNull(message = "you should send person fields")
    private PersonCreateDto person;

    @NotBlank(message = "you should enter username")
    @Size(min = 8, max = 50, message = "username must be between 8 and 50 characters")
    private String username;

    @NotBlank(message = "you should enter password")
    @Size(min = 8, max = 50, message = "password must be between 8 and 50 characters")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonCreateDto getPerson() {
        return person;
    }

    public void setPerson(PersonCreateDto person) {
        this.person = person;
    }

}
