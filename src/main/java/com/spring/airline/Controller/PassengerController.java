package com.spring.airline.Controller;

import com.spring.airline.DTO.PassengerCreateDto;
import com.spring.airline.DTO.PassengerResponseDto;
import com.spring.airline.Service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/getAllPassengers")
    public ResponseEntity<?> getAllPassenger() {
        List<PassengerResponseDto> passengers = passengerService.getAllPassengers();
        if (passengers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no passengers");
        }
        return ResponseEntity.status(HttpStatus.OK).body(passengers);
    }

    @GetMapping("/getByPassengerByPassportNumber")
    public ResponseEntity<?> getByPassengerByPassportNumber(@RequestParam String passportNumber) {
        return ResponseEntity.ok(passengerService.getPassengerByPassport(passportNumber));
    }

    @PostMapping("/addPassenger")
    public ResponseEntity<?> addPassenger(@Valid @RequestBody PassengerCreateDto dto) {
        PassengerResponseDto created = passengerService.addPassenger(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/updatePassengerByPassportNumber")
    public ResponseEntity<?> updatePassengerBYPassportNumber(@RequestParam String passportNumber, @Valid @RequestBody PassengerCreateDto dto) {
        PassengerResponseDto updated = passengerService.updatePassenger(passportNumber, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deletePassengerByPassportNumber")
    public ResponseEntity<?> deletePassengerByPassportNumber(@RequestParam String passportNumber) {
        passengerService.deletePassenger(passportNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("passenger with passportNumber " + passportNumber + " delete successfully");

    }
}
