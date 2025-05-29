package com.spring.airline.Controller;

import com.spring.airline.DTO.GateCreateDto;
import com.spring.airline.DTO.GateResponseDto;
import com.spring.airline.Service.GateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gate")
public class GateController {

    private final GateService gateService;

    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping("/getAllGates")
    public ResponseEntity<?> getAllGates() {
        List<GateResponseDto> gates = gateService.getAllGates();
        if (gates.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No gates available");
        }
        return ResponseEntity.ok(gates);
    }

    @GetMapping("/getGateById")
    public ResponseEntity<?> getGateById(@RequestParam Integer id) {
        return ResponseEntity.ok(gateService.getGateById(id));
    }

    @PostMapping("/addGate")
    public ResponseEntity<?> addGate(@Valid @RequestBody GateCreateDto dto) {
        gateService.addGate(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/updateGateById")
    public ResponseEntity<?> updateGateById(@RequestParam Integer id, @Valid @RequestBody GateCreateDto dto) {
        gateService.updateGate(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deleteGateById")
    public ResponseEntity<?> deleteGateById(@RequestParam Integer id) {
        gateService.deleteGate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
