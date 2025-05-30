package com.spring.airline.Model;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;


@Embeddable
public class WorkShiftTime {
    private LocalDateTime startWorkShiftTime;
    private LocalDateTime endWorkShiftTime;

    public LocalDateTime getStartWorkShiftTime() {
        return startWorkShiftTime;
    }

    public void setStartWorkShiftTime(LocalDateTime startWorkShiftTime) {
        this.startWorkShiftTime = startWorkShiftTime;
    }

    public LocalDateTime getEndWorkShiftTime() {
        return endWorkShiftTime;
    }

    public void setEndWorkShiftTime(LocalDateTime endWorkShiftTime) {
        this.endWorkShiftTime = endWorkShiftTime;
    }
}