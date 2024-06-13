package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.UserDto;
import com.example.demo.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String username) {
        UserDto user = userService.findUser(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PatchMapping({"/update"})
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        String encodedPassword = this.passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        UserDto updatedUser = this.userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping({"/{username}"})
    public ResponseEntity<Void> deleteItem(@PathVariable String username) {
        this.userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
