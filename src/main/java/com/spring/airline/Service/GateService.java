package com.spring.airline.Service;

import com.spring.airline.DTO.FlightResponseDto;
import com.spring.airline.DTO.GateCreateDto;
import com.spring.airline.DTO.GateResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Enums.GateStatus;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.FlightMapper;
import com.spring.airline.Mapper.GateMapper;
import com.spring.airline.Model.Gate;
import com.spring.airline.Repository.GateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {

    private final GateRepository gateRepository;
    private final GateMapper gateMapper;
    private final FlightMapper flightMapper;

    public GateService(GateRepository gateRepository, GateMapper gateMapper,
                       FlightMapper flightMapper) {
        this.gateRepository = gateRepository;
        this.gateMapper = gateMapper;
        this.flightMapper = flightMapper;
    }

    public List<GateResponseDto> getAllGates() {
        return gateRepository.findAll()
                .stream()
                .map(gateMapper::toDto)
                .toList();
    }

    public GateResponseDto getGateById(Integer id) {
        Gate gate = gateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gate with id " + id + " not found"));
        return gateMapper.toDto(gate);
    }

    public Gate addGate(GateCreateDto dto) {
        return gateRepository.save(gateMapper.toModel(dto));
    }

    public Gate updateGate(Integer id, GateCreateDto dto) {
        Gate gate = gateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gate with id " + id + " not found"));
        gateMapper.updateGateFromDto(dto, gate);
        return gateRepository.save(gate);
    }

    public void deleteGate(Integer id) {
        Gate gate = gateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gate with id " + id + " not found"));
        gateRepository.delete(gate);
    }

    public List<GateResponseDto> getGateByStatus(GateStatus status) {
        return gateRepository.findGatesByStatus(status)
                .stream()
                .map(gateMapper::toDto)
                .toList();
    }
}
