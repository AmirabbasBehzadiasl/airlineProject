package com.spring.airline.DTO;

import jakarta.validation.constraints.*;


public class PassengerCreateDto {


    @NotNull(message = "you should enter passportNumber")
    @NotBlank(message = "passportNumber can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9]{12,25}$", message = "Passport number must be between 12 and 25 alphanumeric characters")
    private String passportNumber;

    @NotNull(message = "you should send person fields")
    @NotBlank(message = "person fields can't be empty")
    private PersonCreateDto person;

    public PersonCreateDto getPerson() {
        return person;
    }

    public void setPerson(PersonCreateDto person) {
        this.person = person;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }



}
