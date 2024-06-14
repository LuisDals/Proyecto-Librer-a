package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.BookDto;
import com.example.demo.application.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/allPaged")
    public ResponseEntity<Page<BookDto>> getAllBooksPaged(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BookDto> books = this.bookService.getAllBooksPaged(pageable);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<Page<BookDto>> getBooksByGenre(
            @PathVariable String genre,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BookDto> booksByGenre = this.bookService.getBookByGenre(genre, pageable);
        return ResponseEntity.ok(booksByGenre);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        BookDto book = this.bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        bookDto = this.bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/update", produces = "application/json")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        BookDto bookUpdated = bookService.updateBook(bookDto);
        return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
    }
}
