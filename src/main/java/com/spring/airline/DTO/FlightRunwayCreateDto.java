package com.spring.airline.DTO;

import com.spring.airline.Enums.RunwayStatus;
import jakarta.validation.constraints.NotNull;

public class FlightRunwayCreateDto {

    @NotNull(message = "status is required")
    private RunwayStatus status;

    public  RunwayStatus getStatus() {
        return status;
    }

    public void setStatus (RunwayStatus status) {
        this.status = status;
    }
}
