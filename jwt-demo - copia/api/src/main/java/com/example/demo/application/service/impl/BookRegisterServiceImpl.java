package com.example.demo.application.service.impl;

import com.example.demo.application.dto.BookRegisterDto;
import com.example.demo.application.mapper.BookRegisterMapper;
import com.example.demo.application.service.BookRegisterService;
import com.example.demo.domain.entity.BookRegister;
import com.example.demo.domain.persistence.BookRegisterPersistence;
import com.example.demo.infraestructure.persistence.BookRegisterRepository;
import com.example.demo.infraestructure.persistence.BookRepository;
import com.example.demo.infraestructure.persistence.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookRegisterServiceImpl implements BookRegisterService {
    private final BookRegisterRepository bookRegisterRepository;
    private final BookRegisterMapper bookRegisterMapper;
    private final BookRegisterPersistence bookRegisterPersistence;


    public BookRegisterServiceImpl( BookRegisterRepository bookRegisterRepository, BookRegisterMapper bookRegisterMapper, BookRegisterPersistence bookRegisterPersistence) {
        this.bookRegisterRepository = bookRegisterRepository;
        this.bookRegisterMapper = bookRegisterMapper;
        this.bookRegisterPersistence = bookRegisterPersistence;
    }

    @Override
    public Page<BookRegisterDto> getBookRegisterByUserId(String userId, Pageable pageable) {
        Page<BookRegister> var10000 = this.bookRegisterRepository.findByUserUsername(userId, pageable);
        BookRegisterMapper var10001 = this.bookRegisterMapper;
        Objects.requireNonNull(var10001);
        return var10000.map(var10001::toDto);
    }

    @Override
    public Page<BookRegisterDto> getItems(Pageable pageable) {
        Page<BookRegister> bookRegisterPage = this.bookRegisterPersistence.findAll(pageable);
        BookRegisterMapper var10001 = this.bookRegisterMapper;
        Objects.requireNonNull(var10001);
        return bookRegisterPage.map(var10001::toDto);
    }
}
