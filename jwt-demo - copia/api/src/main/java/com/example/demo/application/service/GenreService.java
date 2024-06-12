package com.example.demo.application.service;

import com.example.demo.application.dto.GenreDto;
import com.example.demo.domain.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    List<Genre>findAll();
    GenreDto createGenre(GenreDto genreDto);
}
