package com.spring.airline.Mapper;

import com.spring.airline.DTO.GateCreateDto;
import com.spring.airline.DTO.GateResponseDto;
import com.spring.airline.Model.Gate;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GateMapper {

    Gate toModel(GateCreateDto dto);

    GateResponseDto toDto(Gate gate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGateFromDto(GateCreateDto dto, @MappingTarget Gate gate);
}
