package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Author;
import com.example.demo.domain.persistence.AuthorPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorPersistenceImpl implements AuthorPersistence {
    private final AuthorRepository authorRepository;

    public AuthorPersistenceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }
}
