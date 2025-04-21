package com.spring.airline.DTO;

import com.spring.airline.Enums.TicketStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigInteger;

public class TicketAdminCreateDto {

    @NotNull(message = "ticketPrice is required")
    @Positive(message = "Ticket price must be positive")
    private BigInteger ticketPrice;

    @NotNull(message = "seatNumber is required")
    @Min(value = 1, message = "Seat number must be greater than 1")
    private Integer seatNumber;

    @NotNull(message = "ticketPrice is required")
    private TicketStatus ticketStatus;

    @NotNull(message = "flight is required")
    private Integer flightId;

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

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
}
