package com.spring.airline.Controller;

import com.spring.airline.DTO.AircraftCreateDto;
import com.spring.airline.DTO.AircraftResponseDto;
import com.spring.airline.DTO.EmployeeResponseDto;
import com.spring.airline.Service.AircraftService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/getAllAircraft")
    public ResponseEntity<?> getAllAircraft() {
        List<AircraftResponseDto> aircraftResponses = aircraftService.getAllAircraft();
        if (aircraftResponses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no aircraft");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aircraftResponses);    }

    @GetMapping("/getAircraftByRegistrationNumber")
    public ResponseEntity<AircraftResponseDto> getAircraftByRegistrationNumber(@RequestParam String registrationNumber) {
        return ResponseEntity.ok(aircraftService.getAircraftByRegistrationNumber(registrationNumber));
    }

    @PostMapping("/addAircraft")
    public ResponseEntity<AircraftResponseDto> addAircraft(@Valid @RequestBody AircraftCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aircraftService.addAircraft(dto));
    }

    @PutMapping("/updateAircraftByRegistrationNumber")
    public ResponseEntity<AircraftResponseDto> updateAircraftByRegistrationNumber(@RequestParam String registrationNumber, @Valid @RequestBody AircraftCreateDto dto) {
        return ResponseEntity.ok(aircraftService.updateAircraftByRegistrationNumber(registrationNumber, dto));
    }

    @DeleteMapping("/deleteAirCraftByRegistrationNumber")
    public ResponseEntity<Void> deleteAirCraftByRegistrationNumber(@RequestParam String registrationNumber) {
        aircraftService.deleteAirCraftByRegistrationNumber(registrationNumber);
        return ResponseEntity.noContent().build();
    }
}
