package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Genre;
import com.example.demo.domain.persistence.GenrePersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GenrePersistenceImpl implements GenrePersistence {
    private final GenreRepository genreRepository;

    public GenrePersistenceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return this.genreRepository.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return this.genreRepository.save(genre);
    }
}
