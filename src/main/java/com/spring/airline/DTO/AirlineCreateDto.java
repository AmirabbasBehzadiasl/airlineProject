package com.spring.airline.DTO;

import com.spring.airline.Enums.Country;
import jakarta.validation.constraints.*;

import java.util.List;

public class AirlineCreateDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contain letters and spaces")
    private String name;

    @NotNull(message = "Country is required")
    private Country country;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(min = 12 , max = 40 , message = "email should be between 5 and 40 character")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private List<String> aircraftName;

    private List<String> employeeNationalCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<String> getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(List<String> aircraftName) {
        this.aircraftName = aircraftName;
    }

    public List<String> getEmployeeNationalCode() {
        return employeeNationalCode;
    }

    public void setEmployeeNationalCode(List<String> employeeNationalCode) {
        this.employeeNationalCode = employeeNationalCode;
    }
}
