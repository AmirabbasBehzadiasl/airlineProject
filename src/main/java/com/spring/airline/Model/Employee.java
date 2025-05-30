package com.spring.airline.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import validation.ValidPhoneNumber;

import java.time.LocalDate;

@Entity
public class Employee extends Person {

    @Column(nullable = false, length = 32)
    private String jobPosition;

    @Column(nullable = false, length = 20)
    @Embedded
    private WorkShiftTime workShift;

    @Column(nullable = false)
    private LocalDate hireDate;

    @ManyToOne()
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public WorkShiftTime getWorkShift() {
        return workShift;
    }

    public void setWorkShift(WorkShiftTime workShift) {
        this.workShift = workShift;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
