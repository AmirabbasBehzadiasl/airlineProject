package com.spring.airline.DTO;

import com.spring.airline.Enums.Country;
import com.spring.airline.Enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class PersonCreateDto {
    @NotNull(message = "you should enter nationalCode")
    @NotBlank(message = "NationalCode can't be empty")
    private String nationalCode;

    @NotNull(message = "you should enter firstName")
    @NotBlank(message = "firstName can't be empty")
    @Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "firstName must only contain letters and spaces")
    private String firstName;

    @NotNull(message = "you should enter lastName")
    @NotBlank(message = "lastName can't be empty")
    @Size(min = 2, max = 50, message = "lastName must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "lastName must only contain letters and spaces")
    private String lastName;

    @NotNull(message = "you should enter phoneNumber")
    @NotBlank(message = "phoneNumber can't be empty")
    private String phoneNumber;

    @NotNull(message = "you should enter birthDate")
    @Past(message = "birthDate must be a past date")
    private LocalDate birthDate;

    @NotNull(message = "you should enter gender")
    @NotBlank(message = "gender can't be empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Email
    @NotNull(message = "you should enter email")
    @NotBlank(message = "email can't be empty")
    @Size(min = 15 , max = 40 , message = "email must be between 15 and 40 alphanumeric characters")
    private String email;

    @NotNull(message = "you should enter Nationality")
    @NotBlank(message = "Nationality can't be empty")
    @Enumerated(EnumType.STRING)
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
