package com.spring.airline.DTO;

import com.spring.airline.Model.WorkShiftTime;

import java.time.LocalDate;

public class EmployeeResponseDto {

    private PersonResponseDto person;

    private String jobPosition;

    private WorkShiftTime workShift;

    private LocalDate hireDate;

    private String airlineName;

    public PersonResponseDto getPerson() {
        return person;
    }

    public void setPerson(PersonResponseDto person) {
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
