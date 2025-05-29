package com.spring.airline.Service;

import com.spring.airline.DTO.GateCreateDto;
import com.spring.airline.DTO.GateResponseDto;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.GateMapper;
import com.spring.airline.Model.Gate;
import com.spring.airline.Repository.GateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {

    private final GateRepository gateRepository;
    private final GateMapper gateMapper;

    public GateService(GateRepository gateRepository, GateMapper gateMapper) {
        this.gateRepository = gateRepository;
        this.gateMapper = gateMapper;
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

    public void addGate(GateCreateDto dto) {
        Gate gate = gateMapper.toModel(dto);
        gateRepository.save(gate);
    }

    public void updateGate(Integer id, GateCreateDto dto) {
        Gate gate = gateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gate with id " + id + " not found"));
        gateMapper.updateGateFromDto(dto, gate);
        gateRepository.save(gate);
    }

    public void deleteGate(Integer id) {
        Gate gate = gateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Gate with id " + id + " not found"));
        gateRepository.delete(gate);
    }
}
