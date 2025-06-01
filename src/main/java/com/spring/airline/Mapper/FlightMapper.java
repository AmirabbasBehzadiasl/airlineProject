package com.spring.airline.Mapper;

import com.spring.airline.DTO.FlightCreateDto;
import com.spring.airline.DTO.FlightResponseDto;
import com.spring.airline.Model.Flight;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    @Mapping(target = "aircraft", ignore = true)
    @Mapping(target = "airline", ignore = true)
    @Mapping(target = "gate", ignore = true)
    @Mapping(target = "runway", ignore = true)
    Flight toModel(FlightCreateDto dto);

    @Mapping(source = "aircraft.registrationNumber", target = "aircraftRegistrationNumber")
    @Mapping(source = "airline.name", target = "airlineName")
    @Mapping(source = "gate.id", target = "gateId")
    @Mapping(source = "runway.id", target = "flightRunwayId")
    FlightResponseDto toDto(Flight flight);

    @Mapping(target = "aircraft", ignore = true)
    @Mapping(target = "airline", ignore = true)
    @Mapping(target = "gate", ignore = true)
    @Mapping(target = "runway", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFlightFromDto(FlightCreateDto dto, @MappingTarget Flight flight);
}
