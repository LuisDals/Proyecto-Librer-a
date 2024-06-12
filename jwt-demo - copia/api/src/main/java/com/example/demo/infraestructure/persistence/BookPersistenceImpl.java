package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.persistence.BookPersistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookPersistenceImpl implements BookPersistence{
    private final BookRepository bookRepository;

    public BookPersistenceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> findAll( Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findByGenre(String genre, Pageable pageable) {
        return this.bookRepository.findByGenre(genre, pageable);
    }

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book) ;
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return this.bookRepository.findById(bookId);
    }
}
