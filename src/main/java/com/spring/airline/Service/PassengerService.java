package com.spring.airline.Service;

import com.spring.airline.DTO.PassengerCreateDto;
import com.spring.airline.DTO.PassengerResponseDto;
import com.spring.airline.Exceptions.AlreadyExistException;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.PassengerMapper;
import com.spring.airline.Model.Passenger;
import com.spring.airline.Repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    public PassengerService(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    public List<PassengerResponseDto> getAllPassengers() {
        return passengerRepository.findAll().stream()
                .map(passengerMapper::toDto)
                .toList();
    }

    public PassengerResponseDto getPassengerByPassport(String passportNumber) {
        Passenger passenger = passengerRepository.findByPassportNumber(passportNumber)
                .orElseThrow(() -> new NotFoundException("Passenger not found with passport number: " + passportNumber));
        return passengerMapper.toDto(passenger);
    }

    public PassengerResponseDto addPassenger(PassengerCreateDto dto) {
        passengerRepository.findByPassportNumber(dto.getPassportNumber())
                .ifPresent(p -> {
                    throw new AlreadyExistException("Passenger with this passport already exists");
                });
        Passenger passenger = passengerMapper.toModel(dto);
        passengerRepository.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    public PassengerResponseDto updatePassenger(String passportNumber, PassengerCreateDto dto) {
        Passenger passenger = passengerRepository.findByPassportNumber(passportNumber)
                .orElseThrow(() -> new NotFoundException("Passenger not found"));
        passengerMapper.updatePassengerFromDto(dto, passenger);
        passengerRepository.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    public void deletePassenger(String passportNumber) {
        Passenger passenger = passengerRepository.findByPassportNumber(passportNumber)
                .orElseThrow(() -> new NotFoundException("Passenger with passportNumber " + passportNumber +  " not found"));
        passengerRepository.delete(passenger);
    }
}
