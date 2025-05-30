package com.spring.airline.DTO;

import com.spring.airline.Enums.Country;

import java.util.List;

public class AirlineResponseDto {

    private String name;

    private Country country;

    private String email;

    private String phoneNumber;

    private List<String> aircraftName;

    private List<String> employeesName;

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

    public List<String> getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(List<String> employeesName) {
        this.employeesName = employeesName;
    }

    public List<String> getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(List<String> aircraftName) {
        this.aircraftName = aircraftName;
    }
}
