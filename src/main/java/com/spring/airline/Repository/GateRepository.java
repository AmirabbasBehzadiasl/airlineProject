package com.spring.airline.Repository;

import com.spring.airline.DTO.GateResponseDto;
import com.spring.airline.Enums.GateStatus;
import com.spring.airline.Model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GateRepository extends JpaRepository<Gate, Integer> {
    List<Gate> findGatesByStatus(GateStatus status);
}
