package com.spring.airline.DTO;

import com.spring.airline.Enums.GateStatus;

import jakarta.validation.constraints.NotNull;

public class GateCreateDto {

    @NotNull(message = "gate status is required")
    private GateStatus status;

    public  GateStatus getStatus() {
        return status;
    }

    public void setStatus (GateStatus status) {
        this.status = status;
    }
}
