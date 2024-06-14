package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.BookDto;
import com.example.demo.application.dto.BookRegisterDto;
import com.example.demo.application.mapper.BookRegisterMapper;
import com.example.demo.application.service.BookService;
import com.example.demo.application.service.impl.RentalRequestServiceImpl;
import com.example.demo.domain.entity.BookRegister;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auth/books")
public class BookController {
    private final BookService bookService;
    private final RentalRequestServiceImpl rentalRequestService;
    private final BookRegisterMapper bookRegisterMapper;

    public BookController(BookService bookService, RentalRequestServiceImpl rentalRequestService, BookRegisterMapper bookRegisterMapper) {
        this.bookService = bookService;
        this.rentalRequestService = rentalRequestService;
        this.bookRegisterMapper = bookRegisterMapper;
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
        BookDto bookUpdated = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
    }

    @PostMapping(value = "/rent", produces = "application/json")
    public ResponseEntity<BookRegisterDto> rentBook(@RequestParam String username, @RequestParam Long bookId,
                                                    @RequestParam Date datePickUp, @RequestParam Date returnDate) {
        BookRegister bookRegister = rentalRequestService.rentBook(username, bookId, datePickUp, returnDate);
        BookRegisterDto bookRegisterDto = bookRegisterMapper.toDto(bookRegister); // Assuming bookRegisterMapper is defined
        return new ResponseEntity<>(bookRegisterDto, HttpStatus.CREATED);
    }

    @GetMapping("/user/{username}/totalRentalDays")
    public ResponseEntity<Integer> getTotalRentalDays(@PathVariable String username) {
        int totalRentalDays = rentalRequestService.getTotalRentalDays(username);
        return ResponseEntity.ok(totalRentalDays);
    }

    /*@PatchMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookDto> updateBook( @RequestBody BookDto bookDto) {
        try {
            BookDto updatedBook = bookService.updateBook(bookDto);
            return ResponseEntity.ok(updatedBook);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/
}
