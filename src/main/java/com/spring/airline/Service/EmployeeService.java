package com.spring.airline.Service;

import com.spring.airline.DTO.EmployeeCreateDto;
import com.spring.airline.DTO.EmployeeResponseDto;
import com.spring.airline.Exceptions.AlreadyExistException;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.EmployeeMapper;
import com.spring.airline.Model.Airline;
import com.spring.airline.Model.Employee;
import com.spring.airline.Repository.AirlineRepository;
import com.spring.airline.Repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;
    AirlineRepository airlineRepository;
    EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper
    , AirlineRepository airlineRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.airlineRepository = airlineRepository;
    }

    public List<EmployeeResponseDto> getAllPersons() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(person -> employeeMapper.toDto(person))
                .toList();
    }

    public EmployeeResponseDto getEmployeeByNationalCode(String nationalCode) {
        Employee employee = employeeRepository.findEmployeeByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException("there is no employee with this National Code : " + nationalCode));
        return employeeMapper.toDto(employee);
    }

    public void addEmployee(EmployeeCreateDto employee) {
        Employee employeeModel =  employeeMapper.toModel(employee);
        employeeRepository.findEmployeeByNationalCode(employee.getPerson().getNationalCode())
                .ifPresent(
                        existingEmployee -> {throw new AlreadyExistException("employee with National Code : " + existingEmployee.getNationalCode()+ " already exist");
                        });
        Airline airline = airlineRepository.findAirlineByName(employee.getAirlineName())
                .orElseThrow(() -> new NotFoundException("airline with name : " + employee.getAirlineName() + " not found"));
        employeeModel.setAirline(airline);
        employeeRepository.save(employeeMapper.toModel(employee));
    }

    public void updateEmployeeByNationalCode(String nationalCode, @Valid EmployeeCreateDto employee) {
        employeeRepository.findEmployeeByNationalCode(nationalCode)
                .ifPresentOrElse(
                        existingEmployee -> {
                          employeeMapper.updateEmployeeFromDto(employee, existingEmployee);
                          Airline airline = airlineRepository.findAirlineByName(employee.getAirlineName())
                                  .orElseThrow(
                                          () -> new NotFoundException("airline with name : " + employee.getAirlineName() + " not found")
                                  );
                          if (!airline.getName().equals(existingEmployee.getAirline().getName())) {
                              existingEmployee.setAirline(airline);
                          }
                          employeeRepository.save(existingEmployee);
                        },
                        () -> { throw new NotFoundException("employee with National Code : " + nationalCode + " not found");});

    }

    public void deleteEmployeeByNationalCode(String nationalCode) {
        Employee employee = employeeRepository.findEmployeeByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException("there is no employee with this National Code : " + nationalCode));
        employeeRepository.delete(employee);
    }
}
