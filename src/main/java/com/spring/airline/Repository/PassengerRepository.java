package com.spring.airline.Repository;

import com.spring.airline.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findByPassportNumber(String passportNumber);
}
