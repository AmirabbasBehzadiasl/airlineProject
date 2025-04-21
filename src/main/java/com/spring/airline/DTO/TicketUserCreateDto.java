package com.spring.airline.DTO;

import com.spring.airline.Enums.TicketClass;
import com.spring.airline.Model.Passenger;
import jakarta.validation.constraints.NotNull;


public class TicketUserCreateDto {

    @NotNull(message = "ticketClass is required")
    private TicketClass ticketClass;

    @NotNull(message = "passenger is required")
    private Passenger passenger;

}
