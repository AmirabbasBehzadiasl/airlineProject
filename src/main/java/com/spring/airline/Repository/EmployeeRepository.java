package com.spring.airline.Repository;

import com.spring.airline.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByNationalCode(String nationalCode);
}
