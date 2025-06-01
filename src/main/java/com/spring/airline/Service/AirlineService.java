package com.spring.airline.Service;

import com.spring.airline.DTO.AirlineCreateDto;
import com.spring.airline.DTO.AirlineResponseDto;
import com.spring.airline.DTO.FlightResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Exceptions.AlreadyExistException;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.AirlineMapper;
import com.spring.airline.Mapper.FlightMapper;
import com.spring.airline.Model.Airline;
import com.spring.airline.Repository.AircraftRepository;
import com.spring.airline.Repository.AirlineRepository;
import com.spring.airline.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper;
    private final FlightMapper flightMapper;

    public AirlineService(AirlineRepository airlineRepository, AirlineMapper airlineMapper
    , FlightMapper flightMapper) {
        this.airlineRepository = airlineRepository;
        this.airlineMapper = airlineMapper;
        this.flightMapper = flightMapper;
    }

    public List<AirlineResponseDto> getAllAirlines() {
        return airlineRepository.findAll().stream()
                .map(airline -> airlineMapper.toDto(airline))
                .toList();
    }

    public AirlineResponseDto getEmployeeByNationalCode(String name) {
        Airline airline = airlineRepository.findAirlineByName(name)
                .orElseThrow(() -> new NotFoundException("there is no airline with this name : " + name));
        return airlineMapper.toDto(airline);
    }

    public void addAirline(AirlineCreateDto airline) {
        Airline airlineModel =  airlineMapper.toModel(airline);
        airlineRepository.findAirlineByName(airlineModel.getName())
                .ifPresent(
                        existingEmployee -> {throw new AlreadyExistException("airline with name : " + airline.getName()+ " already exist");
                        });
        airlineRepository.save(airlineModel);
    }

    public void updateAirlineByName(String name,AirlineCreateDto airline) {
        airlineRepository.findAirlineByName(name)
                .ifPresentOrElse(
                        existingAirline -> {
                            airlineMapper.updateAirlineFromDto(airline, existingAirline);
                            airlineRepository.save(existingAirline);
                        },
                        () -> { throw new NotFoundException("airline with name : " + name + " not found");});
    }

    public void deleteAirlineByName(String name) {
        Airline airline = airlineRepository.findAirlineByName(name)
                .orElseThrow(() -> new NotFoundException("there is no airline with this name : " + name));
        airlineRepository.delete(airline);
    }
}
