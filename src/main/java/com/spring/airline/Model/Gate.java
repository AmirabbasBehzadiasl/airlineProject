package com.spring.airline.Model;

import com.spring.airline.Enums.GateStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false )
    @Enumerated(EnumType.STRING)
    private GateStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
