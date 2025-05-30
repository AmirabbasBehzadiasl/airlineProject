package com.spring.airline.Repository;

import com.spring.airline.DTO.FlightRunwayResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Enums.RunwayStatus;
import com.spring.airline.Model.FlightRunway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRunwayRepository extends JpaRepository<FlightRunway, Integer> {
    List<FlightRunway> findFlightRunwaysByStatus(RunwayStatus status);
}
