package com.spring.airline.Model;

import jakarta.persistence.Embeddable;

import java.time.LocalTime;

@Embeddable
public class WorkShiftTime {
    private LocalTime startWorkShiftTime;
    private LocalTime endWorkShiftTime;
}