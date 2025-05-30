package com.spring.airline.DTO;

import com.spring.airline.Enums.RunwayStatus;
import jakarta.validation.constraints.NotNull;

public class FlightRunwayResponseDto {

    private Integer id;

    private RunwayStatus status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RunwayStatus getStatus() {
        return status;
    }

    public void setStatus(RunwayStatus status) {
        this.status = status;
    }

}
