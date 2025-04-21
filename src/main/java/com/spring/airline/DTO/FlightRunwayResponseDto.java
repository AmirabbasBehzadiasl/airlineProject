package com.spring.airline.DTO;

import com.spring.airline.Enums.RunwayStatus;
import jakarta.validation.constraints.NotNull;

public class FlightRunwayResponseDto {

    @NotNull(message = "status is required")
    private RunwayStatus status;

    public @NotNull(message = "status is required") RunwayStatus getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "status is required") RunwayStatus status) {
        this.status = status;
    }
}
