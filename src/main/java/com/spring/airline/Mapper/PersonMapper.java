package com.spring.airline.Mapper;

import com.spring.airline.DTO.PersonCreateDto;
import com.spring.airline.Model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Named("toPerson")
    default Person toPerson(PersonCreateDto dto) {
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
