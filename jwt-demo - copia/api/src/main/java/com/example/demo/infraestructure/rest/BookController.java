/*
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

@RestController
@RequestMapping({"/auth/books"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<BookDto>> getAllBooks(
            @PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        Page<BookDto> books = this.bookService.getAllBooks(pageable);
        return ResponseEntity.ok(books);
    }


    @GetMapping(value = "/{genre}")
    public ResponseEntity<Page<BookDto>> getBooksByGenre(
            @PathVariable String genre,
            @PageableDefault(size = 10,sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable){
        Page<BookDto> booksByGenre = this.bookService.getBookByGenre(genre, pageable);
        return ResponseEntity.ok(booksByGenre);
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        BookDto book = this.bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookDto> createSong(@RequestBody BookDto bookDto){
        bookDto = this.bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long Id) {
       this.bookService.deleteBook(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        BookDto bookUpDated = bookService.updateBook(bookDto);
        return new ResponseEntity<>(bookUpDated, HttpStatus.OK);
    }
}
*/
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

@RestController
@RequestMapping("/auth/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<BookDto>> getAllBooks(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BookDto> books = this.bookService.getAllBooks(pageable);
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

    @PatchMapping("/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        BookDto bookUpdated = bookService.updateBook(bookDto);
        return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
    }
}
