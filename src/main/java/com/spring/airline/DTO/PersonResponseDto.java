package com.spring.airline.DTO;

import com.spring.airline.Enums.Country;
import com.spring.airline.Enums.Gender;

import java.time.LocalDate;

public class PersonResponseDto {

    private String nationalCode;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private LocalDate birthDate;

    private Gender gender;

    private String email;

    private Country Nationality;

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getNationality() {
        return Nationality;
    }

    public void setNationality(Country nationality) {
        Nationality = nationality;
    }
}
