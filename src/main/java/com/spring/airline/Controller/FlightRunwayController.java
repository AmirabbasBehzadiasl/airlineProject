package com.spring.airline.Controller;

import com.spring.airline.DTO.FlightRunwayCreateDto;
import com.spring.airline.DTO.FlightRunwayResponseDto;
import com.spring.airline.Service.FlightRunwayService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight-runway")
public class FlightRunwayController {

    private final FlightRunwayService runwayService;

    public FlightRunwayController(FlightRunwayService runwayService) {
        this.runwayService = runwayService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllRunways() {
        List<FlightRunwayResponseDto> runways = runwayService.getAllRunways();
        if (runways.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No runways found");
        }
        return ResponseEntity.ok(runways);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getRunwayById(@RequestParam Integer id) {
        return ResponseEntity.ok(runwayService.getRunwayById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRunway(@Valid @RequestBody FlightRunwayCreateDto dto) {
        runwayService.addRunway(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/updateById")
    public ResponseEntity<?> updateRunway(@RequestParam Integer id, @Valid @RequestBody FlightRunwayCreateDto dto) {
        runwayService.updateRunwayById(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteRunway(@RequestParam Integer id) {
        runwayService.deleteRunwayById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
