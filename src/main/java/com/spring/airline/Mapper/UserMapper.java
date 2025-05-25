package com.spring.airline.Mapper;

import com.spring.airline.DTO.UserCreateDto;
import com.spring.airline.DTO.UserResponseDto;
import com.spring.airline.Model.Person;
import com.spring.airline.Model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "person", target = "person", qualifiedByName = "toPerson")
    User toModel(UserCreateDto dto);

    @Mapping(source = "tickets" , target = "purchasedTickets" , qualifiedByName = "toPurchasedTickets")
    UserResponseDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserCreateDto dto, @MappingTarget User user);

    @Named("toPerson")
    default Person mapPersonFromDto(com.spring.airline.DTO.PersonCreateDto dto) {
        if (dto == null) return null;
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setEmail(dto.getEmail());
        person.setNationalCode(dto.getNationalCode());
        person.setPhoneNumber(dto.getPhoneNumber());
        person.setBirthDate(dto.getBirthDate());
        return person;
    }
}
