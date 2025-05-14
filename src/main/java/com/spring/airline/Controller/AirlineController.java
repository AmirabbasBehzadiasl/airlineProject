package com.spring.airline.Controller;

import com.spring.airline.DTO.AirlineCreateDto;
import com.spring.airline.DTO.AirlineResponseDto;
import com.spring.airline.DTO.EmployeeCreateDto;
import com.spring.airline.DTO.EmployeeResponseDto;
import com.spring.airline.Service.AirlineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airline")
public class AirlineController {
    AirlineService airlineService;
    AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("getAllAirlines")
    public ResponseEntity<?> getAllAirlines() {
        List<AirlineResponseDto> airlines = airlineService.getAllAirlines();
        if (airlines.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no airlines");
        }
        return ResponseEntity.status(HttpStatus.OK).body(airlines);
    }

    @GetMapping("/getAirlineByName")
    public ResponseEntity<?> getEmployeeByNationalCode(@RequestParam String name) {
        AirlineResponseDto response = airlineService.getEmployeeByNationalCode(name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addAirline")
    public ResponseEntity<?> addAirline(@Valid @RequestBody AirlineCreateDto airline) {
        airlineService.addAirline(airline);
        return ResponseEntity.status(HttpStatus.CREATED).body(airline);
    }

    @PutMapping("/updateAirlineByName")
    public ResponseEntity<?> updateAirlineByName(@RequestParam String name,@Valid @RequestBody AirlineCreateDto airline){
        airlineService.updateAirlineByName(name,airline);
        return ResponseEntity.status(HttpStatus.OK).body(airline);
    }

    @DeleteMapping("/deleteAirlineByName")
    public ResponseEntity<?> deleteAirlineByName(@RequestParam String name) {
        airlineService.deleteAirlineByName(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("airline with name " +name + " delete successfully");
    }

}
