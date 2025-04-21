package com.spring.airline.DTO;

import com.spring.airline.Enums.Country;
import jakarta.validation.constraints.*;

import java.util.List;

public class AirlineCreateDto {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name can't be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contain letters and spaces")
    private String name;

    @NotNull(message = "Country is required")
    private Country country;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email can't be blank")
    @Email(message = "Invalid email format")
    @Size(min = 12 , max = 40 , message = "email should be between 5 and 40 character")
    private String email;

    @NotNull(message = "Phone number is required")
    @NotBlank(message = "Phone number can't be empty")
    private String phoneNumber;

    private List<Integer> aircraftId;

    private List<Integer> employeeId;

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

    public List<Integer> getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(List<Integer> aircraftId) {
        this.aircraftId = aircraftId;
    }

    public List<Integer> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<Integer> employeeId) {
        this.employeeId = employeeId;
    }
}
