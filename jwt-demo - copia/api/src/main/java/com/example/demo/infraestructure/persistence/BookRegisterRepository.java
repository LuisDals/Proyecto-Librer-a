package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.BookRegister;
import com.example.demo.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRegisterRepository  extends JpaRepository<BookRegister, Long> {
    BookRegister findByUserAndBook(User user, Book book);
    Page<BookRegister> findByUserUsername(String userId, Pageable pageable);
}
