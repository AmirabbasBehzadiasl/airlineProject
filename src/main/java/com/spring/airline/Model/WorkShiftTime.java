package com.spring.airline.Model;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;


@Embeddable
public class WorkShiftTime {
    private LocalDateTime startWorkShiftTime;
    private LocalDateTime endWorkShiftTime;
}