package com.spring.airline.Mapper;

import com.spring.airline.DTO.EmployeeCreateDto;
import com.spring.airline.DTO.EmployeeResponseDto;
import com.spring.airline.Model.Airline;
import com.spring.airline.Model.Employee;
import com.spring.airline.Repository.AirlineRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring" , uses = {PersonMapper.class})
public interface EmployeeMapper {

    @Mapping(source = "airlineName" , target = " airline" , ignore = true)
    @Mapping(source = "person", target = ".", qualifiedByName = "toPerson")
    Employee toModel(EmployeeCreateDto employee);

    @Mapping( source = "airline.name ", target = "airlineName")
    @Mapping(source=".", target="person", qualifiedByName="toDto")
    EmployeeResponseDto toDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person", target = ".", qualifiedByName = "toPerson")
    void updateEmployeeFromDto(EmployeeCreateDto dto, @MappingTarget Employee employee);

}
