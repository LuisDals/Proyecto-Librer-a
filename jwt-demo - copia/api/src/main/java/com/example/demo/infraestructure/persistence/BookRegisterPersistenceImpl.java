package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.BookRegister;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.persistence.BookRegisterPersistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class BookRegisterPersistenceImpl implements BookRegisterPersistence {
    private final BookRegisterRepository bookRegisterRepository;

    public BookRegisterPersistenceImpl(BookRegisterRepository bookRegisterRepository) {
        this.bookRegisterRepository = bookRegisterRepository;
    }

    @Override
    public Page<BookRegister> findAll(Pageable pageable) {
        return this.bookRegisterRepository.findAll(pageable);
    }

    @Override
    public Page<BookRegister> findByUserId(String userId, Pageable pageable) {
        return this.bookRegisterRepository.findByUserUsername(userId, pageable);
    }

    @Override
    public BookRegister findByUserAndBook(User user, Book book) {
        return this.bookRegisterRepository.findByUserAndBook(user, book);
    }


}
