package com.spring.airline.DTO;


public class PassengerResponseDto {

    private String passportNumber;

    private TicketResponseDto ticket;

    private PersonResponseDto person;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public PersonResponseDto getPerson() {
        return person;
    }

    public void setPerson(PersonResponseDto person) {
        this.person = person;
    }

    public TicketResponseDto getTicket() {
        return ticket;
    }

    public void setTicket(TicketResponseDto ticket) {
        this.ticket = ticket;
    }
}
