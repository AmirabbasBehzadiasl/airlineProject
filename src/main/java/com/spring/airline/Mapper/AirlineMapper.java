package com.spring.airline.Mapper;

import com.spring.airline.DTO.AirlineCreateDto;
import com.spring.airline.DTO.AirlineResponseDto;
import com.spring.airline.Model.Airline;
import com.spring.airline.Model.Employee;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AirlineMapper {

    @Mapping(target = "aircraft", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Airline toModel(AirlineCreateDto airlineCreateDto);

    @Mapping(source = "aircraft.name" , target = "aircraftName")
    @Mapping(source = "employees" , target = "employeesNationalCode" , qualifiedByName = "employeeMap")
    AirlineResponseDto toDto(Airline airline);

    @Mapping(target = "aircraft", source = "aircraftName" , ignore = true)
    @Mapping(target = "employees", source = "employeesNationalCode" , ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAirlineFromDto(AirlineCreateDto airlineCreateDto,@MappingTarget Airline airline);

    @Named("employeeMap")
    default List<String> employeeMap(List<Employee> employees) {
        List<String> employeesNationalCode = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) {
                employeesNationalCode.add(employee.getNationalCode());
            }
        }
        return employeesNationalCode;
    }
}
