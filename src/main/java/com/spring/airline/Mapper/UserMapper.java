package com.spring.airline.Mapper;

import com.spring.airline.DTO.UserCreateDto;
import com.spring.airline.DTO.UserResponseDto;
import com.spring.airline.Model.Person;
import com.spring.airline.Model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring" ,  uses = {TicketMapper.class , PersonMapper.class})
public interface UserMapper {

    @Mapping(source = "person", target = "person", qualifiedByName = "toPerson")
    User toModel(UserCreateDto dto);

    @Mapping(source = "tickets" , target = "purchasedTickets" , qualifiedByName = "toPurchasedTickets")
    UserResponseDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserCreateDto dto, @MappingTarget User user);

}
