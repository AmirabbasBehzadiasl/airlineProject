package com.spring.airline.Mapper;

import com.spring.airline.DTO.EmployeeCreateDto;
import com.spring.airline.DTO.EmployeeResponseDto;
import com.spring.airline.Model.Airline;
import com.spring.airline.Model.Employee;
import com.spring.airline.Repository.AirlineRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    AirlineRepository airlineRepository = null;
    

    @Mapping(source = "airlineName" , target = " airline" , ignore = true)
    Employee toModel(EmployeeCreateDto employee);

    @Mapping( source = "airline.name ", target = "airlineName")
    EmployeeResponseDto toDto(Employee employee);

    @Mapping(source = "airlineName", target = "airline" , ignore = true)
    @Mapping(source = "person.firstName", target = "firstName")
    @Mapping(source = "person.lastName", target = "lastName")
    @Mapping(source = "person.birthDate", target = "birthDate")
    @Mapping(source = "person.email", target = "email")
    @Mapping(source = "person.nationalCode", target = "nationalCode")
    @Mapping(source = "person.gender", target = "gender")
    @Mapping(source = "person.phoneNumber", target = "phoneNumber")
    @Mapping(source = "person.nationality", target = "nationality")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromDto(EmployeeCreateDto dto, @MappingTarget Employee employee);

}
