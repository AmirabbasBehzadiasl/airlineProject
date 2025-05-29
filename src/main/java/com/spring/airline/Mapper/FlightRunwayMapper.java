package com.spring.airline.Mapper;

import com.spring.airline.DTO.FlightRunwayCreateDto;
import com.spring.airline.DTO.FlightRunwayResponseDto;
import com.spring.airline.Model.FlightRunway;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FlightRunwayMapper {

    FlightRunway toModel(FlightRunwayCreateDto dto);

    FlightRunwayResponseDto toDto(FlightRunway flightRunway);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRunwayFromDto(FlightRunwayCreateDto dto, @MappingTarget FlightRunway flightRunway);
}
