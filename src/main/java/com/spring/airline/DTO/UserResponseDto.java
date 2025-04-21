package com.spring.airline.DTO;

import com.spring.airline.Model.Ticket;

import java.util.List;

public class UserResponseDto {

    private String username;

    private PersonResponseDto person;

    private List<Ticket> purchasedTickets;

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

    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(List<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }


}
