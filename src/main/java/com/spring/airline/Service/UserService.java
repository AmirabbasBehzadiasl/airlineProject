package com.spring.airline.Service;

import com.spring.airline.DTO.UserCreateDto;
import com.spring.airline.DTO.UserResponseDto;
import com.spring.airline.Exceptions.AlreadyExistException;
import com.spring.airline.Exceptions.NotFoundException;
import com.spring.airline.Mapper.UserMapper;
import com.spring.airline.Model.User;
import com.spring.airline.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username: " + username + " not found"));
        return userMapper.toDto(user);
    }
        @Transactional
        public void addUser(UserCreateDto userDto) {
        userRepository.findByUsername(userDto.getUsername())
                .ifPresent(existing -> {
                    throw new AlreadyExistException("User with username: " + userDto.getUsername() + " already exists");
                });
        userRepository.save(userMapper.toModel(userDto));
    }

    public void updateUserByUsername(String username, UserCreateDto userDto) {
        userRepository.findByUsername(username)
                .ifPresentOrElse(
                        existingUser -> {
                            userMapper.updateUserFromDto(userDto, existingUser);
                            userRepository.save(existingUser);
                        },
                        () -> {
                            throw new NotFoundException("User with username: " + username + " not found");
                        });
    }

    public void deleteUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username: " + username + " not found"));
        userRepository.delete(user);
    }
}
