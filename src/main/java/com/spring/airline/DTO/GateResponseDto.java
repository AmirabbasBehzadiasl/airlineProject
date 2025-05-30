package com.spring.airline.DTO;

import com.spring.airline.Enums.GateStatus;


public class GateResponseDto {

    private Integer id;
    private GateStatus status;

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
