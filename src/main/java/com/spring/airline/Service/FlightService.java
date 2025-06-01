package com.spring.airline.Service;

import com.spring.airline.DTO.FlightCreateDto;
import com.spring.airline.DTO.FlightResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Exceptions.AlreadyExistException;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.FlightMapper;
import com.spring.airline.Model.*;
import com.spring.airline.Repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;
    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;
    private final GateRepository gateRepository;
    private final FlightRunwayRepository runwayRepository;
    private final FlightMapper flightMapper;

    public FlightService(FlightRepository flightRepository,
                         AircraftRepository aircraftRepository,
                         AirlineRepository airlineRepository,
                         GateRepository gateRepository,
                         FlightRunwayRepository runwayRepository,
                         FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.aircraftRepository = aircraftRepository;
        this.airlineRepository = airlineRepository;
        this.gateRepository = gateRepository;
        this.runwayRepository = runwayRepository;
        this.flightMapper = flightMapper;
    }

    public List<FlightResponseDto> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper::toDto)
                .toList();
    }

    public FlightResponseDto getFlightByNumber(Integer flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new NotFoundException("flight with number: " + flightNumber +"Not Found"));
        return flightMapper.toDto(flight);
    }

    public List<FlightResponseDto> getFlightsByAircraft(String registrationNumber, FlightStatus status) {
        List<Flight> flights = flightRepository.findByAircraft_RegistrationNumber(registrationNumber);
        return filterAndMap(flights, status);
    }

    public List<FlightResponseDto> getFlightsByGate(Integer gateId, FlightStatus status) {
        List<Flight> flights = flightRepository.findByGate_Id(gateId);
        return filterAndMap(flights, status);
    }

    public List<FlightResponseDto> getFlightsByRunway(Integer runwayId, FlightStatus status) {
        List<Flight> flights = flightRepository.findByRunway_Id(runwayId);
        return filterAndMap(flights, status);
    }

    public List<FlightResponseDto> getFlightsByAirline(String airlineName, FlightStatus status) {
        List<Flight> flights = flightRepository.findByAirline_Name(airlineName);
        return filterAndMap(flights, status);
    }

    private List<FlightResponseDto> filterAndMap(List<Flight> flights, FlightStatus status) {
        return flights.stream()
                .filter(flight -> status == null || flight.getFlightStatus() == status)
                .map(flightMapper::toDto)
                .toList();
    }

    public FlightResponseDto addFlight(FlightCreateDto dto) {
        if (flightRepository.existsByFlightNumber(dto.getFlightNumber())) {
            throw new AlreadyExistException("Flight number already exists: " + dto.getFlightNumber());
        }

        Flight flight = flightMapper.toModel(dto);

        flight.setAircraft(aircraftRepository.findAircraftByRegistrationNumber(dto.getAircraftRegistrationNumber())
                .orElseThrow(() -> new NotFoundException("Aircraft with RegistrationNumber "+ dto.getAircraftRegistrationNumber() +" not found")));

        flight.setAirline(airlineRepository.findAirlineByName(dto.getAirlineName())
                .orElseThrow(() -> new NotFoundException("Airline with name " + dto.getAirlineName()+ " not found")));

        flight.setGate(gateRepository.findById(dto.getGateId())
                .orElseThrow(() -> new NotFoundException("Gate with id "+dto.getGateId()+" not found")));

        flight.setRunway(runwayRepository.findById(dto.getFlightRunwayId())
                .orElseThrow(() -> new NotFoundException("Runway with id "+ dto.getFlightRunwayId() + "not found")));

        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        long countToday = flightRepository.countByCreatedAtBetween(startOfDay, endOfDay);

        if (countToday >= 200) {
            throw new IllegalStateException("Maximum of 200 flights can be scheduled per day.");
        }

        flight.setFlightNumber((int) countToday + 1);

        return flightMapper.toDto(flightRepository.save(flight));
    }

    public FlightResponseDto updateFlightByNumber(Integer flightNumber, FlightCreateDto dto) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new NotFoundException("Flight not found with number: " + flightNumber));

        flightMapper.updateFlightFromDto(dto, flight);

        flight.setAircraft(aircraftRepository.findAircraftByRegistrationNumber(dto.getAircraftRegistrationNumber())
                .orElseThrow(() -> new NotFoundException("Aircraft with RegistrationNumber "+ dto.getAircraftRegistrationNumber() +" not found")));

        flight.setAirline(airlineRepository.findAirlineByName(dto.getAirlineName())
                .orElseThrow(() -> new NotFoundException("Airline with name " + dto.getAirlineName()+ " not found")));

        flight.setGate(gateRepository.findById(dto.getGateId())
                .orElseThrow(() -> new NotFoundException("Gate with id "+dto.getGateId()+" not found")));

        flight.setRunway(runwayRepository.findById(dto.getFlightRunwayId())
                .orElseThrow(() -> new NotFoundException("Runway with id "+ dto.getFlightRunwayId() + "not found")));

        return flightMapper.toDto(flightRepository.save(flight));
    }

    public void deleteFlightByNumber(Integer flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new NotFoundException("Flight not found with number: " + flightNumber));
        flightRepository.delete(flight);
    }
}
