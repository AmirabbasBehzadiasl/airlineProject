package com.spring.airline.Repository;

import com.spring.airline.Model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    Optional<Aircraft> findAircraftByRegistrationNumber(String registrationNumber);
}
