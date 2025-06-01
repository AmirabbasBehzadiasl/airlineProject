package com.spring.airline.DTO;

import com.spring.airline.Enums.FlightStatus;

import java.time.LocalDateTime;
import java.util.List;

public class FlightResponseDto {
    private Integer flightNumber;
    private String origin;
    private String destination;
    private FlightStatus flightStatus;
    private Integer availableSeats;
    private LocalDateTime timeOfFlight;
    private LocalDateTime arrivalTime;
    private List<String> passengers;
    private String aircraftRegistrationNumber;
    private String airlineName;
    private Integer GateId;
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

    public FlightStatus getFlightStatus() {
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

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<String> passengers) {
        this.passengers = passengers;
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

    public Integer getGateId() {
        return GateId;
    }

    public void setGateId(Integer gateId) {
        GateId = gateId;
    }

    public Integer getFlightRunwayId() {
        return flightRunwayId;
    }

    public void setFlightRunwayId(Integer flightRunwayId) {
        this.flightRunwayId = flightRunwayId;
    }
}
