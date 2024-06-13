package com.example.demo.application.service.impl;

import com.example.demo.application.dto.BookDto;
import com.example.demo.application.dto.UserDto;
import com.example.demo.application.mapper.BookMapper;
import com.example.demo.application.service.BookService;
import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.persistence.BookPersistence;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookPersistence bookPersistence;

    public BookServiceImpl(BookMapper bookMapper, BookPersistence bookPersistence) {
        this.bookMapper = bookMapper;
        this.bookPersistence = bookPersistence;
    }


    @Override
    public Page<BookDto> getAllBooks(Pageable pageable) {
        Page<Book> bookPage = bookPersistence.findAll(pageable);
        return bookPage.map(bookMapper::toDto);
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Optional<Book> optionalBook = this.bookPersistence.findById(bookId);
        Book book = optionalBook.get();
        return this.bookMapper.toDto(book);
    }

    @Override
    public Page<BookDto> getBookByGenre(String genre, Pageable pageable) {
        Page<Book> books = bookPersistence.findByGenre(genre, pageable);
        return books.map(bookMapper::toDto);
    }


    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = this.bookMapper.toEntity(bookDto);
        book = this.bookPersistence.save(book);
        return this.bookMapper.toDto(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        this.bookPersistence.deleteBook(bookId);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Optional<Book> bookOptional = this.bookPersistence.findById(bookDto.getId());
        if (bookOptional.isPresent()) {
            Book book = (Book)this.bookMapper.toEntity(bookDto);
            Book updatedBook = this.bookPersistence.updateBook(book);
            return (BookDto)this.bookMapper.toDto(updatedBook);
        } else {
            throw new EntityNotFoundException("Usuario no encontrado con nombre de usuario: " + bookDto.getId());
        }
    }
}
