package com.spring.airline.Controller;

import com.spring.airline.DTO.FlightCreateDto;
import com.spring.airline.DTO.FlightResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/getAllFlights")
    public ResponseEntity<?> getAllFlights() {
        List<FlightResponseDto> flights = flightService.getAllFlights();
        if (flights.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no flights");
        }
        return ResponseEntity.status(HttpStatus.OK).body(flights);
    }

    @GetMapping("/getFlightByNumber")
    public ResponseEntity<?> getFlightByNumber(@RequestParam Integer flightNumber) {
        return ResponseEntity.ok(flightService.getFlightByNumber(flightNumber));
    }

    @GetMapping("/getFlightsByAircraft")
    public ResponseEntity<List<FlightResponseDto>> getFlightsByAircraft(
            @RequestParam String registrationNumber,
            @RequestParam(required = false) FlightStatus status
    ) {
        return ResponseEntity.ok(flightService.getFlightsByAircraft(registrationNumber, status));
    }

    @GetMapping("/getFlightsByGate")
    public ResponseEntity<List<FlightResponseDto>> getFlightsByGate(
            @RequestParam Integer gateId,
            @RequestParam(required = false) FlightStatus status
    ) {
        return ResponseEntity.ok(flightService.getFlightsByGate(gateId, status));
    }

    @GetMapping("/getFlightsByRunway")
    public ResponseEntity<List<FlightResponseDto>> getFlightsByRunway(
            @RequestParam Integer runwayId,
            @RequestParam(required = false) FlightStatus status
    ) {
        return ResponseEntity.ok(flightService.getFlightsByRunway(runwayId, status));
    }

    @GetMapping("/getFlightsByAirline")
    public ResponseEntity<List<FlightResponseDto>> getFlightsByAirline(
            @RequestParam String airlineName,
            @RequestParam(required = false) FlightStatus status
    ) {
        return ResponseEntity.ok(flightService.getFlightsByAirline(airlineName, status));
    }

    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@Valid @RequestBody FlightCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.addFlight(dto));
    }

    @PutMapping("/updateFlightByNumber")
    public ResponseEntity<?> updateFlight(@RequestParam Integer flightNumber, @Valid @RequestBody FlightCreateDto dto) {
        return ResponseEntity.ok(flightService.updateFlightByNumber(flightNumber, dto));
    }

    @DeleteMapping("/deleteFlightByNumber")
    public ResponseEntity<?> deleteFlight(@RequestParam Integer flightNumber) {
        flightService.deleteFlightByNumber(flightNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
