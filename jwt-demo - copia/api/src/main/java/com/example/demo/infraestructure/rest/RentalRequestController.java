package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.RentRequestDto;
import com.example.demo.application.service.impl.RentalRequestServiceImpl;
import com.example.demo.domain.entity.BookRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RentalRequestController {
    @Autowired
    private RentalRequestServiceImpl rentalService;

    @PostMapping("/rent")
    public ResponseEntity<BookRegister> rentBook(@RequestBody RentRequestDto rentRequest) {
        BookRegister bookRegister = rentalService.rentBook(
                rentRequest.getUsername(),
                rentRequest.getBookId(),
                rentRequest.getDatePickUp(),
                rentRequest.getReturnDate()
        );
        return ResponseEntity.ok(bookRegister);
    }

    @GetMapping("/total-rental-days/{username}")
    public ResponseEntity<Integer> getTotalRentalDays(@PathVariable String username) {
        int totalRentalDays = rentalService.getTotalRentalDays(username);
        return ResponseEntity.ok(totalRentalDays);
    }
}
