package com.spring.airline.DTO;

import com.spring.airline.Model.Ticket;

import java.util.List;

public class UserResponseDto {

    private String username;

    private PersonResponseDto person;

    private List<TicketResponseDto> purchasedTickets;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PersonResponseDto getPerson() {
        return person;
    }

    public void setPerson(PersonResponseDto person) {
        this.person = person;
    }

    public List<TicketResponseDto> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(List<TicketResponseDto> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }


}
