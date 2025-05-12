package com.spring.airline.DTO;

import com.spring.airline.Model.WorkShiftTime;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class EmployeeCreateDto {

    private PersonCreateDto person;

    @NotBlank(message = "you should enter jobPosition")
    private String jobPosition;

    @NotNull(message = "you should enter workShift")
    private WorkShiftTime workShift;

    @PastOrPresent(message = "you should enter hireDate")
    @NotNull(message = "hireDate is required")
    private LocalDate hireDate;

    @NotBlank(message = "you should enter ")
    private String airlineName;

    public PersonCreateDto getPerson() {
        return person;
    }

    public void setPerson(PersonCreateDto person) {
        this.person = person;
    }

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

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
