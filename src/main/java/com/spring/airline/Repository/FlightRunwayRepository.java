package com.spring.airline.Repository;

import com.spring.airline.Model.FlightRunway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRunwayRepository extends JpaRepository<FlightRunway, Integer> {
}
