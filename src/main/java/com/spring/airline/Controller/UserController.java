package com.spring.airline.Controller;

import com.spring.airline.DTO.UserCreateDto;
import com.spring.airline.DTO.UserResponseDto;
import com.spring.airline.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there are no users");
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUserByUsername")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserCreateDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping("/updateUserByUsername")
    public ResponseEntity<?> updateUser(@RequestParam String username, @Valid @RequestBody UserCreateDto userDto) {
        userService.updateUserByUsername(username, userDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/deleteUserByUsername")
    public ResponseEntity<?> deleteUser(@RequestParam String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(username);
    }
}
