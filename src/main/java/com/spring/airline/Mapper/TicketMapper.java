package com.spring.airline.Mapper;

import com.spring.airline.DTO.TicketResponseDto;
import com.spring.airline.Model.Passenger;
import com.spring.airline.Model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(source =  "flight.flightNumber", target = "flightNumber" )
    @Mapping(source =  "passenger", target = "passenger" , qualifiedByName = "toPassenger")
    TicketResponseDto toDto(Ticket ticket);

    @Named("toPassenger")
    default String toPassenger(Passenger passenger) {
        if (passenger != null)
          return passenger.getFirstName() + passenger.getLastName();
        return null;
    }

}
