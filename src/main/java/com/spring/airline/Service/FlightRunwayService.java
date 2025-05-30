package com.spring.airline.Service;

import com.spring.airline.DTO.FlightRunwayCreateDto;
import com.spring.airline.DTO.FlightRunwayResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Enums.RunwayStatus;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.FlightRunwayMapper;
import com.spring.airline.Model.FlightRunway;
import com.spring.airline.Repository.FlightRunwayRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightRunwayService {

    private final FlightRunwayRepository runwayRepository;
    private final FlightRunwayMapper runwayMapper;

    public FlightRunwayService(FlightRunwayRepository runwayRepository, FlightRunwayMapper runwayMapper) {
        this.runwayRepository = runwayRepository;
        this.runwayMapper = runwayMapper;
    }

    public List<FlightRunwayResponseDto> getAllRunways() {
        return runwayRepository.findAll()
                .stream()
                .map(runwayMapper::toDto)
                .toList();
    }

    public FlightRunwayResponseDto getRunwayById(Integer id) {
        FlightRunway runway = runwayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runway with ID " + id + " not found"));
        return runwayMapper.toDto(runway);
    }

    public FlightRunwayResponseDto addRunway(FlightRunwayCreateDto dto) {
        FlightRunway flightRunway = runwayRepository.save(runwayMapper.toModel(dto));
        return runwayMapper.toDto(flightRunway);
    }

    public FlightRunwayResponseDto updateRunwayById(Integer id, FlightRunwayCreateDto dto) {
        FlightRunway runway = runwayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runway with ID " + id + " not found"));
        runwayMapper.updateRunwayFromDto(dto, runway);
        runwayRepository.save(runway);
        return runwayMapper.toDto(runway);
    }

    public void deleteRunwayById(Integer id) {
        FlightRunway runway = runwayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runway with ID " + id + " not found"));
        runwayRepository.delete(runway);
    }

    public List<FlightRunwayResponseDto> getFlightRunwayByStatus(RunwayStatus status) {
        return runwayRepository.findFlightRunwaysByStatus(status)
                .stream()
                .map(runwayMapper::toDto)
                .toList();

    }
}
