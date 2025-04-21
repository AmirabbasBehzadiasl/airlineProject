package com.spring.airline.Model;

import com.spring.airline.Enums.FlightStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true , nullable=false)
    @NotNull(message = "you should enter flightNumber")
    @NotBlank(message = "flightNumber can't be empty")
    @Min(value = 1 , message = "flightNumber must be at least 1")
    @Max(value = 200 , message = "flightNumber must be at most 200")
    private Integer flightNumber;

    @Column(nullable = false, length = 50)
    @NotNull(message =  "you should enter origin")
    @NotBlank(message = "origin can't be empty")
    @Size(min = 3 , max = 50 , message = "origin must be between 3 and 50 character")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "origin must only contain letters and spaces")
    private String origin;

    @Column(nullable = false, length = 50)
    @NotNull(message =  "you should enter destination")
    @NotBlank(message = "destination can't be empty")
    @Size(min = 3 , max = 50 , message = "destination must be between 3 and 50 character")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "destination must only contain letters and spaces")
    private String destination;

    @Column(nullable = false, length = 10)
    @NotNull(message = "you should enter flightStatus")
    @NotBlank(message = "flightStatus can't be empty")
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    @Column(nullable = false)
    @NotNull(message = "you should enter availableSeats")
    @NotBlank(message = "availableSeats can't be empty")
    private Integer availableSeats;

    @Column(nullable = false)
    @NotNull(message = "you should enter timeOfFlight")
    @Future
    private LocalDateTime timeOfFlight;

    @Column(nullable = false)
    @NotNull(message = "you should enter arrivalTime")
    @Future
    private LocalDateTime arrivalTime;

    // it's optional (don't add any field to table)
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
