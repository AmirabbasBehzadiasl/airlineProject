package com.spring.airline.Repository;

import com.spring.airline.Model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepository extends JpaRepository<Gate, Integer> {
}
