package com.spring.airline.Mapper;

import com.spring.airline.DTO.AirlineCreateDto;
import com.spring.airline.DTO.AirlineResponseDto;
import com.spring.airline.Model.Aircraft;
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

    @Mapping(source = "aircraft" , target = "aircraftName" , qualifiedByName = "aircraftMap")
    @Mapping(source = "employees" , target = "employeesName" , qualifiedByName = "employeeMap")
    AirlineResponseDto toDto(Airline airline);

    @Mapping(target = "aircraft", ignore = true)
    @Mapping(target = "employees",  ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAirlineFromDto(AirlineCreateDto airlineCreateDto,@MappingTarget Airline airline);

    @Named("employeeMap")
    default List<String> employeeMap(List<Employee> employees) {
        List<String> employeesName = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) {
                employeesName.add(employee.getFirstName()+employee.getLastName());
            }
        }
        return employeesName;
    }
    @Named("aircraftMap")
    default List<String> aircraftMap(List<Aircraft> aircrafts) {
        List<String> aircraftModels = new ArrayList<>();
        for (Aircraft aircraft : aircrafts){
            aircraftModels.add(aircraft.getModel());
        }
        return aircraftModels;
    }
}
