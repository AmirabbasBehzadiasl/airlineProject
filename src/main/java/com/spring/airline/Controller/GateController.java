package com.spring.airline.Controller;

import com.spring.airline.DTO.GateCreateDto;
import com.spring.airline.DTO.GateResponseDto;
import com.spring.airline.Enums.GateStatus;
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no gates");
        }
        return ResponseEntity.ok(gates);
    }

    @GetMapping("/getGateById")
    public ResponseEntity<?> getGateById(@RequestParam Integer id) {
        return ResponseEntity.ok(gateService.getGateById(id));
    }

    @GetMapping("/getGateByStatus")
    public ResponseEntity<?> getGateByStatus(@RequestParam GateStatus status) {
        return ResponseEntity.ok(gateService.getGateByStatus(status));
    }
    @PostMapping("/addGate")
    public ResponseEntity<?> addGate(@Valid @RequestBody GateCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gateService.addGate(dto));
    }
    @PutMapping("/updateGateById")
    public ResponseEntity<?> updateGateById(@RequestParam Integer id, @Valid @RequestBody GateCreateDto dto) {
        return ResponseEntity.ok(gateService.updateGate(id, dto));
    }

    @DeleteMapping("/deleteGateById")
    public ResponseEntity<?> deleteGateById(@RequestParam Integer id) {
        gateService.deleteGate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
