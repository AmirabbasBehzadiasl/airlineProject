package com.spring.airline.Repository;

import com.spring.airline.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(Integer flightNumber);
    List<Flight> findByAircraft_RegistrationNumber(String registrationNumber);
    List<Flight> findByGate_Id(Integer gateId);
    List<Flight> findByRunway_Id(Integer runwayId);
    List<Flight> findByAirline_Name(String airlineName);
    long countByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    boolean existsByFlightNumber(Integer flightNumber);
}
