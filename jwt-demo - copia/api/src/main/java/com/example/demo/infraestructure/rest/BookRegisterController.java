package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.BookRegisterDto;
import com.example.demo.application.service.BookRegisterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class BookRegisterController {
    private final BookRegisterService bookRegisterService;

    public BookRegisterController(BookRegisterService bookRegisterService) {
        this.bookRegisterService = bookRegisterService;
    }

    @GetMapping({"usersd"})
    public Page<BookRegisterDto> getAllItems(Pageable pageable){
        return this.bookRegisterService.getItems(pageable);
    }

    @GetMapping({"/book-registers/{userId}"})
    public ResponseEntity<Page<BookRegisterDto>> getPlayRegistersByUserId(@PathVariable String userId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2147483647") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BookRegisterDto> playRegistersPage = this.bookRegisterService.getBookRegisterByUserId(userId, pageable);
        return ResponseEntity.ok(playRegistersPage);
    }
}
