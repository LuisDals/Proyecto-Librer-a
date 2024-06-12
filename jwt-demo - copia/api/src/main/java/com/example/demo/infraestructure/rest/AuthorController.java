package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.AuthorDto;
import com.example.demo.application.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/auth"})
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "create-author",produces = "application/json", consumes = "application/json")
    public ResponseEntity<AuthorDto> createSong(@RequestBody AuthorDto authorDto){
        authorDto = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(authorDto, HttpStatus.CREATED);
    }
}
