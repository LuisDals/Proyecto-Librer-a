package com.example.demo.domain.persistence;

import com.example.demo.domain.entity.Author;

public interface AuthorPersistence {
    Author save(Author author);
}
