package com.spring.airline.Mapper;

import com.spring.airline.DTO.PassengerCreateDto;
import com.spring.airline.DTO.PassengerResponseDto;
import com.spring.airline.Model.Passenger;
import com.spring.airline.Model.Person;
import org.mapstruct.*;

@Mapper(componentModel = "spring" , uses = {PersonMapper.class})
public interface PassengerMapper {

    @Mapping(source = "person", target = "person", qualifiedByName = "toPerson")
    Passenger toModel(PassengerCreateDto dto);

    PassengerResponseDto toDto(Passenger passenger);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePassengerFromDto(PassengerCreateDto dto, @MappingTarget Passenger passenger);

}
