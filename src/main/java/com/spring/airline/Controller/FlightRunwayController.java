package com.spring.airline.Controller;

import com.spring.airline.DTO.FlightRunwayCreateDto;
import com.spring.airline.DTO.FlightRunwayResponseDto;
import com.spring.airline.Enums.FlightStatus;
import com.spring.airline.Enums.RunwayStatus;
import com.spring.airline.Service.FlightRunwayService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flightRunway")
public class FlightRunwayController {

    private final FlightRunwayService runwayService;

    public FlightRunwayController(FlightRunwayService runwayService) {
        this.runwayService = runwayService;
    }

    @GetMapping("/getAllFlightRunways")
    public ResponseEntity<?> getAllFlightRunways() {
        List<FlightRunwayResponseDto> runways = runwayService.getAllRunways();
        if (runways.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no runways");
        }
        return ResponseEntity.ok(runways);
    }

    @GetMapping("/getFlightRunwayById")
    public ResponseEntity<?> getRunwayById(@RequestParam Integer id) {
        return ResponseEntity.ok(runwayService.getRunwayById(id));
    }

    @GetMapping("/getFlightRunwayByStatus")
    public ResponseEntity<?> getFlightRunwayByStatus(@RequestParam RunwayStatus status) {
        return ResponseEntity.ok(runwayService.getFlightRunwayByStatus(status));
    }

    @PostMapping("/addFlightRunway")
    public ResponseEntity<?> addFlightRunway(@Valid @RequestBody FlightRunwayCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(runwayService.addRunway(dto));
    }

    @PutMapping("/updateFlightRunwayById")
    public ResponseEntity<?> updateFlightRunway(@RequestParam Integer id, @Valid @RequestBody FlightRunwayCreateDto dto) {
        return ResponseEntity.ok(runwayService.updateRunwayById(id, dto));
    }

    @DeleteMapping("/deleteFlightRunwaysById")
    public ResponseEntity<?> deleteFlightRunway(@RequestParam Integer id) {
        runwayService.deleteRunwayById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
