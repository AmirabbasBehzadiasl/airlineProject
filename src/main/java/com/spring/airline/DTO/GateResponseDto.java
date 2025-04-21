package com.spring.airline.DTO;

import com.spring.airline.Enums.GateStatus;


public class GateResponseDto {

    private GateStatus status;

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
