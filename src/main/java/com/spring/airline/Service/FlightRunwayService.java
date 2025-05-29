package com.spring.airline.Service;

import com.spring.airline.DTO.FlightRunwayCreateDto;
import com.spring.airline.DTO.FlightRunwayResponseDto;
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

    public void addRunway(@Valid FlightRunwayCreateDto dto) {
        FlightRunway runway = runwayMapper.toModel(dto);
        runwayRepository.save(runway);
    }

    public void updateRunwayById(Integer id, @Valid FlightRunwayCreateDto dto) {
        FlightRunway runway = runwayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runway with ID " + id + " not found"));
        runwayMapper.updateRunwayFromDto(dto, runway);
        runwayRepository.save(runway);
    }

    public void deleteRunwayById(Integer id) {
        FlightRunway runway = runwayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Runway with ID " + id + " not found"));
        runwayRepository.delete(runway);
    }
}
