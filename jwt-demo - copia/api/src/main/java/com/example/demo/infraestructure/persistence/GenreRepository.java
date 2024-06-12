package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
