package com.example.demo.application.service;

import com.example.demo.application.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public interface BookService {
    Page<BookDto> getAllBooksPaged(Pageable pageable);
    BookDto getBookById(Long bookId);
    Page<BookDto>getBookByGenre(String genre, Pageable pageable);
    BookDto createBook(BookDto bookDto);
    void deleteBook(Long bookId);
    BookDto updateBook(BookDto bookDto);
    List<BookDto> getAllBooks();
}
