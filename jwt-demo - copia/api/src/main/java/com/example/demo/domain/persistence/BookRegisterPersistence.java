package com.example.demo.domain.persistence;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.BookRegister;
import com.example.demo.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRegisterPersistence {
    Page<BookRegister> findAll(Pageable pageable);
    Page<BookRegister> findByUserId(String userId, Pageable pageable);
    BookRegister findByUserAndBook(User user, Book book);
}
