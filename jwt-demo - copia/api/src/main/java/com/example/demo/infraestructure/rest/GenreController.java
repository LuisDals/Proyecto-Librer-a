package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.GenreDto;
import com.example.demo.application.service.GenreService;
import com.example.demo.domain.entity.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/auth/genre"})
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping({"/all"})
    public List<Genre> findAllByGenre(){
        return this.genreService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<GenreDto> createSong(@RequestBody GenreDto genreDto){
        genreDto = this.genreService.createGenre(genreDto);
        return new ResponseEntity<>(genreDto, HttpStatus.CREATED);
    }
}
