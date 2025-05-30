package com.spring.airline.Mapper;

import com.spring.airline.DTO.UserCreateDto;
import com.spring.airline.DTO.UserResponseDto;
import com.spring.airline.Model.Person;
import com.spring.airline.Model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring" ,  uses = {TicketMapper.class , PersonMapper.class})
public interface UserMapper {

    @Mapping(source = "person", target = ".", qualifiedByName = "toPerson")
    User toModel(UserCreateDto dto);

    @Mapping(source=".", target="person", qualifiedByName="toDto")
    @Mapping(source = "tickets", target = "purchasedTickets")
    UserResponseDto toDto(User user);

    @Mapping(source = "person", target = ".", qualifiedByName = "toPerson")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserCreateDto dto, @MappingTarget User user);

}
