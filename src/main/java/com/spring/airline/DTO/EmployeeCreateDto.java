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

    @NotNull(message = "jobPosition is required")
    @NotBlank(message = "jobPosition can't be empty")
    private String jobPosition;

    @NotNull(message = "workShift is required")
    @NotBlank(message = "workShift can't be empty")
    private WorkShiftTime workShift;

    @PastOrPresent(message = "hireDate can't be in the future")
    @NotNull(message = "hireDate is required")
    @NotBlank(message = "hireDate can't be empty")
    private LocalDate hireDate;

    @NotNull
    @Min(value = 1,message = "airline must be more than one")
    private Integer airlineId;

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

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }
}
