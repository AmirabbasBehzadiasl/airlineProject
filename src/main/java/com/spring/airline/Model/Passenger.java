package com.spring.airline.Model;

import jakarta.persistence.*;

@Entity
public class Passenger extends Person {

    @Column(length = 25)
    private String passportNumber;

    @OneToOne(mappedBy = "passenger")
    private Ticket ticket;

    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


}
