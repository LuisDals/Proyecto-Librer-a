package com.example.demo.application.service.impl;

import com.example.demo.application.dto.GenreDto;
import com.example.demo.application.mapper.GenreMapper;
import com.example.demo.application.service.GenreService;
import com.example.demo.domain.entity.Genre;
import com.example.demo.domain.persistence.GenrePersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreMapper genreMapper;
    private final GenrePersistence genrePersistence;
    public GenreServiceImpl( GenrePersistence genrePersistence,GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
        this.genrePersistence = genrePersistence;
    }

    @Override
    public List<Genre> findAll() {
        return this.genrePersistence.findAll();
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = this.genreMapper.toEntity(genreDto);
        genre = this.genrePersistence.save(genre);
        return this.genreMapper.toDto(genre);
    }
}
