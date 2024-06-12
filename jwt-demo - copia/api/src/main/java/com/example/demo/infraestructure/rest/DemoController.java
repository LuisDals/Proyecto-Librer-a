package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.UserDto;
import com.example.demo.application.service.AuthService;
import com.example.demo.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

   // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from secure endpoint");
        return response;
    }
}
