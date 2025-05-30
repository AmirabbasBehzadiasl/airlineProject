package com.spring.airline.Controller;

import com.spring.airline.DTO.EmployeeCreateDto;
import com.spring.airline.DTO.EmployeeResponseDto;
import com.spring.airline.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/employee")
public class EmployeeController {

    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeResponseDto> employees = employeeService.getAllPersons();
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no employees");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/getEmployeeByNationalCode")
    public ResponseEntity<?> getEmployeeByNationalCode(@RequestParam String nationalCode) {
        EmployeeResponseDto response = employeeService.getEmployeeByNationalCode(nationalCode);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeCreateDto employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
    }
    @PutMapping("/updateEmployeeByNationalCode")
    public ResponseEntity<?> updateEmployeeByNationalCode(@RequestParam String nationalCode,@Valid @RequestBody EmployeeCreateDto employee){
        employeeService.updateEmployeeByNationalCode(nationalCode,employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping("/deleteEmployeeByNationalCode")
    public ResponseEntity<?> deleteEmployeeByNationalCode(@RequestParam String nationalCode) {
        employeeService.deleteEmployeeByNationalCode(nationalCode);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nationalCode);
    }
}
