package com.example.demo.domain.persistence;

import com.example.demo.domain.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookPersistence {
    Page<Book> findAll(Pageable pageable);
    Page<Book> findByGenre(String genre, Pageable pageable);
    Book save(Book book);
    Optional<Book> findById(Long bookId);
    void deleteBook(Long bookId);
    Book updateBook(Book book);
}
