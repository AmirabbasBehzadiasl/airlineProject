package com.spring.airline.Repository;

import com.spring.airline.Model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    Optional<Airline> findAirlineByName(String airlineName);

}
