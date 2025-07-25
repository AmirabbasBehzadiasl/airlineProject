package com.spring.airline.DTO;

import com.spring.airline.Model.Ticket;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public class PassengerCreateDto {


    @NotBlank(message = "you should enter passportNumber")
    @Pattern(regexp = "^[A-Za-z0-9]{12,25}$", message = "Passport number must be between 12 and 25 alphanumeric characters")
    private String passportNumber;

    private TicketUserCreateDto ticket;

    @Valid
    @NotNull(message = "you should send person fields")
    private PersonCreateDto person;

    public PersonCreateDto getPerson() {
        return person;
    }

    public void setPerson(PersonCreateDto person) {
        this.person = person;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public TicketUserCreateDto getTicket() {
        return ticket;
    }

    public void setTicket(TicketUserCreateDto ticket) {
        this.ticket = ticket;
    }
}
