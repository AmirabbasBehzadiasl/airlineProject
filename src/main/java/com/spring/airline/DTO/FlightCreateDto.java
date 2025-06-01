package com.spring.airline.DTO;

import com.spring.airline.Enums.FlightStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class FlightCreateDto {

    @NotNull(message = "you should enter flightNumber")
    @Min(value = 1 , message = "flightNumber must be at least 1")
    @Max(value = 200 , message = "flightNumber must be at most 200")
    private Integer flightNumber;

    @NotBlank(message = "origin can't be empty")
    @Size(min = 3 , max = 50 , message = "origin must be between 3 and 50 character")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "origin must only contain letters and spaces")
    private String origin;

    @NotBlank(message = "destination can't be empty")
    @Size(min = 3 , max = 50 , message = "destination must be between 3 and 50 character")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "destination must only contain letters and spaces")
    private String destination;

    @NotNull(message = "you should enter flightStatus")
    private FlightStatus flightStatus;

    @NotNull(message = "you should enter availableSeats")
    private Integer availableSeats;

    @NotNull(message = "you should enter timeOfFlight")
    @Future
    private LocalDateTime timeOfFlight;

    @NotNull(message = "you should enter arrivalTime")
    @Future
    private LocalDateTime arrivalTime;

    @NotBlank(message = "you should enter aircraftRegistrationNumber ")
    private String aircraftRegistrationNumber;

    @NotBlank(message = "you should enter airlineName ")
    private String airlineName;

    @NotNull(message = "you should enter GateId ")
    private Integer GateId;

    @NotNull(message = "you should enter flightRunwayId")
    private Integer flightRunwayId;



    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public  FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getTimeOfFlight() {
        return timeOfFlight;
    }

    public void setTimeOfFlight(LocalDateTime timeOfFlight) {
        this.timeOfFlight = timeOfFlight;
    }

    public  LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraftRegistrationNumber() {
        return aircraftRegistrationNumber;
    }

    public void setAircraftRegistrationNumber(String aircraftRegistrationNumber) {
        this.aircraftRegistrationNumber = aircraftRegistrationNumber;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public  Integer getGateId() {
        return GateId;
    }

    public void setGateId (Integer gateId) {
        GateId = gateId;
    }

    public  Integer getFlightRunwayId() {
        return flightRunwayId;
    }

    public void setFlightRunwayId(Integer flightRunwayId) {
        this.flightRunwayId = flightRunwayId;
    }
}
