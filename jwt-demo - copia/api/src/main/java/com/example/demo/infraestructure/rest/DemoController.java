package com.example.demo.infraestructure.rest;


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
