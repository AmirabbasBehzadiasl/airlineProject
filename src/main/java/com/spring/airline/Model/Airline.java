package com.spring.airline.Model;

import com.spring.airline.Enums.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import validation.ValidPhoneNumber;

import java.util.List;

@Entity
@ValidPhoneNumber
@Table(name = "airline", indexes = {@Index(name = "idx_airline_name", columnList = "name")})
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 16)
    private String phoneNumber;

    @OneToMany(mappedBy = "airline")
    private List<Aircraft> aircraft;

    @OneToMany(mappedBy = "airline")
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
