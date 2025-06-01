package com.spring.airline.Service;

import com.spring.airline.DTO.AircraftCreateDto;
import com.spring.airline.DTO.AircraftResponseDto;
import com.spring.airline.DTO.FlightResponseDto;
import com.spring.airline.Exceptions.AlreadyExistException;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.AircraftMapper;
import com.spring.airline.Mapper.FlightMapper;
import com.spring.airline.Model.Aircraft;
import com.spring.airline.Model.Airline;
import com.spring.airline.Model.Flight;
import com.spring.airline.Repository.AircraftRepository;
import com.spring.airline.Repository.AirlineRepository;
import com.spring.airline.Repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;
    private final AircraftMapper aircraftMapper;
    private final FlightMapper flightMapper;

    public AircraftService(AircraftRepository aircraftRepository, AirlineRepository airlineRepository, AircraftMapper aircraftMapper
    , FlightMapper flightMapper) {
        this.aircraftRepository = aircraftRepository;
        this.airlineRepository = airlineRepository;
        this.aircraftMapper = aircraftMapper;
        this.flightMapper = flightMapper;
    }

    public List<AircraftResponseDto> getAllAircraft() {
        return aircraftRepository.findAll()
                .stream()
                .map(aircraftMapper::toDto)
                .toList();
    }

    public AircraftResponseDto getAircraftByRegistrationNumber(String registrationNumber) {
        Aircraft aircraft = aircraftRepository.findAircraftByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new NotFoundException("Aircraft with registrationNumber " + registrationNumber + " not found"));
        return aircraftMapper.toDto(aircraft);
    }

    public AircraftResponseDto addAircraft(AircraftCreateDto dto) {
        if (aircraftRepository.existsByRegistrationNumber(dto.getRegistrationNumber())) {
            throw new AlreadyExistException("Aircraft with registration number " + dto.getRegistrationNumber() + " already exists");
        }

        Airline airline = airlineRepository.findAirlineByName(dto.getAirlineName())
                .orElseThrow(() -> new NotFoundException("Airline with name " + dto.getAirlineName() + " not found"));

        Aircraft aircraft = aircraftMapper.toModel(dto);
        aircraft.setAirline(airline);
        return aircraftMapper.toDto(aircraftRepository.save(aircraft));
    }

    public AircraftResponseDto updateAircraftByRegistrationNumber(String registrationNumber, AircraftCreateDto dto) {
        Aircraft aircraft = aircraftRepository.findAircraftByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new NotFoundException("Aircraft with registrationNumber" + registrationNumber + " not found"));

        Airline airline = airlineRepository.findAirlineByName(dto.getAirlineName())
                .orElseThrow(() -> new NotFoundException("Airline with name " + dto.getAirlineName() + " not found"));

        aircraftMapper.updateFromDto(dto, aircraft);
        aircraft.setAirline(airline);
        return aircraftMapper.toDto(aircraftRepository.save(aircraft));
    }

    public void deleteAirCraftByRegistrationNumber(String registrationNumber) {
        Aircraft aircraft = aircraftRepository.findAircraftByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new NotFoundException("Aircraft with registrationNumber " + registrationNumber + " not found"));
        aircraftRepository.delete(aircraft);
    }
}
