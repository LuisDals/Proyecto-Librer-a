package com.example.demo.domain.persistence;

import com.example.demo.domain.entity.Genre;

import java.util.List;

public interface GenrePersistence {
    List<Genre> findAll();
    Genre save(Genre genre);
}
