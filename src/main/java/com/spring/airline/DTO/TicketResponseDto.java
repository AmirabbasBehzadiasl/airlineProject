package com.spring.airline.DTO;

import com.spring.airline.Enums.TicketClass;
import com.spring.airline.Enums.TicketStatus;

import java.math.BigInteger;

public class TicketResponseDto {

    private BigInteger ticketPrice;
    private Integer seatNumber;
    private TicketStatus ticketStatus;
    private String flightNumber;
    private TicketClass ticketClass;
    private PassengerResponseDto passenger;

    public BigInteger getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigInteger ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public PassengerResponseDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerResponseDto passenger) {
        this.passenger = passenger;
    }
}
