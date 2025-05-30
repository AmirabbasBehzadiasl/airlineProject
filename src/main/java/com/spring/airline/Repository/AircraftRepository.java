package com.spring.airline.Repository;

import com.spring.airline.Model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    boolean existsByRegistrationNumber(String registrationNumber);

    Optional<Aircraft> findAircraftByRegistrationNumber(String registrationNumber);
}
