package com.spring.airline.DTO;

import com.spring.airline.Enums.OperationalStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AircraftCreateDto {

    @NotBlank(message = "model is required")
    @Size(min = 5 , max = 50 , message = "model should be between 5 and 50 character")
    private String model;

    @NotBlank(message = "Registration can't be empty")
    @Size(min = 5 , max = 50 , message = "registrationNumber should be between 5 and 50 character")
    private String registrationNumber;

    @NotNull(message = "dateOfManufacture is required")
    @Past(message = "Date of manufacture must be in the past")
    private LocalDate dateOfManufacture;

    @NotNull(message = "passengerCapacity is required")
    @Min(value = 1, message = "Passenger capacity must be at least 1")
    private Integer passengerCapacity;

    @NotNull(message = "Operational status is required")
    private OperationalStatus operationalStatus;

    @NotBlank(message = "airline is required")
    private String airlineName;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public OperationalStatus getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(OperationalStatus operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirline(String airlineName) {
        this.airlineName = airlineName;
    }

}
