package com.spring.airline.Mapper;

import com.spring.airline.DTO.AircraftCreateDto;
import com.spring.airline.DTO.AircraftResponseDto;
import com.spring.airline.Model.Aircraft;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AircraftMapper {

    @Mapping(target = "airline",  ignore = true)
    Aircraft toModel(AircraftCreateDto dto);

    @Mapping(source = "airline.name", target = "airlineName")
    AircraftResponseDto toDto(Aircraft aircraft);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "airline" , ignore = true)
    void updateFromDto(AircraftCreateDto dto, @MappingTarget Aircraft entity);
}
