package com.spring.airline.Mapper;

import com.spring.airline.DTO.PersonCreateDto;
import com.spring.airline.DTO.PersonResponseDto;
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

    @Named("toDto")
    default PersonResponseDto toDto(Person person) {
        if (person == null) return null;
        PersonResponseDto dto = new PersonResponseDto();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setNationalCode(person.getNationalCode());
        dto.setPhoneNumber(person.getPhoneNumber());
        dto.setBirthDate(person.getBirthDate());
        dto.setGender(person.getGender());
        dto.setCountry(person.getCountry());
        return dto;
    }
}
